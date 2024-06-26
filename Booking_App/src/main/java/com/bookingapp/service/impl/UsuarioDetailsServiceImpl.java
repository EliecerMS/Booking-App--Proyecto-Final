package com.bookingapp.service.impl;

import com.bookingapp.dao.UsuarioDao;
import com.bookingapp.domain.Rol;
import com.bookingapp.domain.Usuario;
import com.bookingapp.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alonso
 */

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService{
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private HttpSession session;
    
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        
        // se busca el usuario que pasamos por parametro en la base de datos
        Usuario usuario = usuarioDao.findByUsername(username);
        
        // se valida si se recuperó un usuario, sino lanza un error
        if( usuario == null ){
            throw new UsernameNotFoundException(username);
        }
        
        // se recuperó la información del usuario y se agrega la imagen del usuario
        session.removeAttribute("usuarioID");
        session.removeAttribute("usuarioImagen");
        session.removeAttribute("nombreCompleto");
        session.removeAttribute("usuarioNombre");
        session.removeAttribute("usuarioPrimerApellido");
        session.removeAttribute("usuarioSegundoApellido");
        session.removeAttribute("usuarioCorreo");
        session.removeAttribute("usuarioTelefono");

        session.setAttribute("usuarioID", usuario.getIdUsuario());
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        session.setAttribute("nombreCompleto", usuario.getNombre() + " " + usuario.getPrimer_apellido() + " " + usuario.getSegundo_apellido());
        session.setAttribute("usuarioNombre", usuario.getNombre());
        session.setAttribute("usuarioPrimerApellido", usuario.getPrimer_apellido());
        session.setAttribute("usuarioSegundoApellido", usuario.getSegundo_apellido());
        session.setAttribute("usuarioCorreo", usuario.getEmail());
        session.setAttribute("usuarioTelefono", usuario.getTelefono());
        
        // se van a recuperar los roles del usuario y se crean los roles ya como seguridad de spring
        // BD: ADMIN .... ROLE_ADMIN
        var roles = new ArrayList<GrantedAuthority>();
        for( Rol rol : usuario.getRoles() ){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        
        
        return new User(usuario.getUsername(),usuario.getPassword(),roles);
    }
}
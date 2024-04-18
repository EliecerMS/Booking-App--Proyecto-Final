/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookingapp.service.impl;

import com.bookingapp.domain.Usuario;
import com.bookingapp.service.CorreoService;
import com.bookingapp.service.RegistroService;
import com.bookingapp.service.UsuarioService;
import jakarta.mail.MessagingException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 *
 * @author kenca
 */
@Service
public class RegistroServiceImpl implements RegistroService{
    
    /*@Autowired
    private CorreoService correoService;*/
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private MessageSource messageSource;  
   
 
    @Override
    public Model crearUsuario(Model model, Usuario usuario) 
            throws MessagingException {
        String mensaje;
        if (!usuarioService.existeUsuarioPorUsernameOEmail(usuario.getUsername(), usuario.getEmail())) {
            //String clave = demeClave();
            //Encode de la clave
            var codigo = new BCryptPasswordEncoder();
            usuario.setPassword(codigo.encode(usuario.getPassword()));
            usuario.setActivo(true);
            usuarioService.save(usuario, true);
            mensaje = String.format( messageSource.getMessage("registro.mensaje.activacion.ok", null, Locale.getDefault()), usuario.getEmail());
        } else {
            mensaje = String.format(messageSource.getMessage("registro.mensaje.usuario.o.correo", null, Locale.getDefault()),usuario.getUsername(), usuario.getEmail());
        }
        model.addAttribute("titulo", messageSource.getMessage("registro.activar", null, Locale.getDefault()));
        model.addAttribute("mensaje", mensaje);
        return model;
    }

    @Override
    public Model recordarUsuario(Model model, Usuario usuario) 
            throws MessagingException {
        String mensaje;
        String enlace;
        String nombreEnlace;
        Usuario usuario2 = usuarioService.existeUsuarioPorEmailYTelefono(usuario.getEmail(), usuario.getTelefono()); /// agregado ------------
        if (usuario2 != null) {
            usuario2.setActivo(false);
            usuarioService.save(usuario2, false);
            mensaje = String.format( messageSource.getMessage("recuperar.username", null, Locale.getDefault()),usuario2.getUsername());
            enlace = "reestablecerAcceso/"+usuario2.getIdUsuario();
            nombreEnlace = "Reestablecer contraseña";
            model.addAttribute("enlace", enlace);
            model.addAttribute("nombreEnlace", nombreEnlace);
        }
        else{
            mensaje = String.format(messageSource.getMessage("registro.mensaje.recordar.no.encontrado", null, Locale.getDefault()),
                    usuario.getUsername(), usuario.getEmail());
        }
        model.addAttribute("titulo", messageSource.getMessage("registro.activar", null, Locale.getDefault()));
        model.addAttribute("mensaje", mensaje);
        
        return model;
    }


    @Override
     public Model cambiarContrasennaUsuario(Model model, Usuario usuario) throws MessagingException{
         String mensaje;
        
        Usuario usuario2 = usuarioService.getUsuario(usuario);
        if (usuario2 != null) {
            var codigo = new BCryptPasswordEncoder();
            usuario2.setPassword(codigo.encode(usuario.getPassword()));
            usuario2.setActivo(true);
            usuarioService.save(usuario2, false);
            mensaje = String.format( messageSource.getMessage("contrasenna.success", null, Locale.getDefault()));
        }
        else{
            mensaje = String.format(messageSource.getMessage("contrasenna.fail", null, Locale.getDefault()));
        }
        model.addAttribute("titulo", messageSource.getMessage("registro.activar", null, Locale.getDefault()));
        model.addAttribute("mensaje", mensaje);
        
        return model;
     }
}
package com.bookingapp.controller;

import com.bookingapp.domain.Usuario;
import com.bookingapp.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kenca
 * @author alonso
 */
@Controller
@Slf4j
@RequestMapping("/perfil")
public class PerfilController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("")
    public String perfilInicio (Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        Usuario usuario = usuarioService.getUsuarioPorUsername(username);
        
        model.addAttribute("title", "Mi perfil");
        model.addAttribute(usuario);
        
        return "/perfil/perfil";
    }
    
    
    @PostMapping("/guardar")
    public String pefilGuardar( long idUsuario, 
            @RequestParam("nombre") String nombre,
            @RequestParam("primer_apellido") String primer_apellido, 
            @RequestParam("segundo_apellido") String segundo_apellido, 
            @RequestParam("telefono") String telefono, 
            @RequestParam("email") String email, 
            @RequestParam("username") String username, 
            @RequestParam("imagenFile") MultipartFile imagenFile) {    
        usuarioService.saveUpdate( idUsuario, nombre, primer_apellido, segundo_apellido, telefono, email, username, imagenFile.getName() );
        return "redirect:/perfil";
    }

}
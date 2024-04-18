/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookingapp.controller;

import com.bookingapp.domain.Usuario;
import com.bookingapp.service.RegistroService;
import com.bookingapp.service.UsuarioService;
import jakarta.mail.MessagingException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author eliec
 */
@Controller
@Slf4j // como se comunica con la base de datos
@RequestMapping("registro")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @Autowired
    private UsuarioService usuarioService;


    /*======================================================
    * RUTA: default a formulario de registro
    * dejamos el mapping vacio, pero internamente
    * sabemos que en esta ruta hace referencia a la pagina de formulario
    ======================================================*/
    @GetMapping("")
    public String nuevo(Model model, Usuario usuario) {
        return "registro/registro";
    }

    @GetMapping("/recordar")
    public String recordar(Model model, Usuario usuario) {
        return "registro/recordar";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(Model model, Usuario usuario)
            throws MessagingException {
        model = registroService.crearUsuario(model, usuario);
        return "/registro/salida";
    }

    @PostMapping("/recordarUsuario")
    public String recordarUsuario(Model model, Usuario usuario)
            throws MessagingException {
        model = registroService.recordarUsuario(model, usuario);
        return "/registro/salida";
    }

    @GetMapping("/reestablecerAcceso/{idUsuario}")
    public String reestablecerAcceso(Model model, Usuario usuario) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/registro/reestablecer";
    }

    @PostMapping("/cambiarContrasenna")
    public String cambiarContrasenna(Model model, Usuario usuario)
            throws MessagingException {
        model = registroService.cambiarContrasennaUsuario(model, usuario);
        return "/registro/salida";
    }
    
    

}

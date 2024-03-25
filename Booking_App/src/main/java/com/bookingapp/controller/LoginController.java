/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookingapp.controller;


import com.bookingapp.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author eliec
 */
@Controller
@Slf4j // como se comunica con la base de datos
@RequestMapping("/login")
public class LoginController {
        @Autowired
    private LoginService loginService;
    
        
    /*======================================================
    * RUTA: default a iniciar sesion
    * dejamos el mapping vacio, pero internamente
    * sabemos que en esta ruta hace referencia a iniciar sesion
    ======================================================*/
    @GetMapping("")
    public String inicio(Model model){
        //var logins = loginService.getLogin();
        //model.addAttribute("logins",logins);
        //model.addAttribute("totalLogins", logins.size());
        model.addAttribute("title", "Login");
        return "/login/iniciarSesion";
    }
}

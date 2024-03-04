package com.bookingapp.controller;

import com.bookingapp.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alonso
 */

@Controller
@Slf4j // como se comunica con la base de datos
@RequestMapping("login")
public class LoginController {
    
     
    // sin parametro para o vacio, acá mostramos el formulario de login
    @GetMapping("")
    public String inicio(Model model){
        
        return "login/login";
    }
    
    
    @GetMapping("{dato_prueba}")
    private void getDato(@PathVariable("dato_prueba") String dato_prueba)   
    {  
        System.out.println("el dato es:"+dato_prueba);
    }      

    
}
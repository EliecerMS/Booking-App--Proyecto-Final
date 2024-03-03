/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookingapp.controller;

import com.bookingapp.service.RegistroService;
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
@RequestMapping("registro")
public class RegistroController {

    @Autowired
    private RegistroService registroService;
    
    @GetMapping("/registro")
    public String inicio(Model model){
       // var registros = registroService.getRegistro();
       // model.addAttribute("registros",registros);
        //model.addAttribute("totalRegistros", registros.size());
        return "registro/registro";
    }
}

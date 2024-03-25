/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookingapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alonso
 */
@Controller // todas las funcionalidades de un controlador
@Slf4j // esta es la que hace comunicacion con las bases de datos
@RequestMapping("/faqs")
public class FaqsController {
    
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Preguntas frecuentes");
        return "/faqs/faqs";
    }

}
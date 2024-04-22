/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookingapp.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


/**
 *
 * @author kenca
 */
@Controller
@Slf4j
@RequestMapping("/facturacion")
public class FacturacionController {

    @GetMapping("")
    public String inicio(Model model) {
        model.addAttribute("title", "Facturacion");
        return "facturacion/facturacion";
    }
}





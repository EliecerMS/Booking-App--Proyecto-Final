/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookingapp.controller;

import com.bookingapp.domain.Destino;
import com.bookingapp.service.DestinoService;
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
@RequestMapping("/destinos")
public class DestinoController {
    @Autowired
    private DestinoService destinoService;
    
    @GetMapping("/listado")
    public String inicio(Model model){
        var destinos = destinoService.getDestinos();
        model.addAttribute("destinos",destinos);
        model.addAttribute("totalDestinos", destinos.size());
        return "/destinos/listado";
    }
    
    
    
    @GetMapping("detallesDestino/{idDestino}")
    public String verDetallesDestino(Destino destino, Model model){
        destino = destinoService.getDestino(destino);
        model.addAttribute("destino", destino);
        return "/destinos/detallesDestino";
    }
}

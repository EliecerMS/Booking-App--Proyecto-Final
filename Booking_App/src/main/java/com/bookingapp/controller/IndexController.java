package com.bookingapp.controller;

import com.bookingapp.service.DestinoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Alonso
 */
@Controller // todas las funcionalidades de un controlador
@Slf4j // esta es la que hace comunicacion con las bases de datos
@RequestMapping("")
public class IndexController {
    
    @Autowired
    private DestinoService destinoService;
    
    @GetMapping("")
    public String index(Model model) {
        var destinos = destinoService.getDestinos();
        model.addAttribute("destinos",destinos);
        model.addAttribute("totalDestinos", destinos.size());
        model.addAttribute("title", "Inicio");
        return "/index";
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookingapp.controller;

import com.bookingapp.domain.Destino;
import com.bookingapp.service.DestinoService;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author eliec
 * @author Alonso
 */
@Controller
@Slf4j // como se comunica con la base de datos
@RequestMapping("/destinos")
public class DestinoController {
    @Autowired
    private DestinoService destinoService;
    
    
    
    /*======================================================
    * RUTA: LISTADO
    * dejamos el mapping vacio, pero internamente
    * sabemos que en esta ruta hace referencia a listado
    ======================================================*/
    @GetMapping("/listado")
    public String inicio(Model model){
        var destinos = destinoService.getDestinos();
        model.addAttribute("destinos",destinos);
        model.addAttribute("totalDestinos", destinos.size());
        model.addAttribute("title", "Destinos");
        return "/destinos/listado";
    }
    /*======================================================*/
    
    
    @GetMapping("detallesDestino/{idDestino}")
    public String verDetallesDestino(Destino destino, Model model, HttpSession session){
        destino = destinoService.getDestino(destino);
        model.addAttribute("destino", destino);
        model.addAttribute("usuarioID", session.getAttribute("usuarioID"));
        return "/destinos/detallesDestino";
    }
    
     @PostMapping("/queryPrecio")
    public String consultaPrecio(@RequestParam(value = "precioSup") double precioSup, Model model) {
        var destinos = destinoService.filtrarPrecioNoche(precioSup);
        model.addAttribute("destinos", destinos);
        model.addAttribute("totalDestinos", destinos.size());
        
        model.addAttribute("precioSup", precioSup);
        return "/destinos/listado";
    }
    
     @PostMapping("/filtroTotal")
    public String filtroTotal(@RequestParam(value = "precioSup", required = false) Double precioSup, @RequestParam(value = "fechaInicio") String startDate, 
            @RequestParam(value = "fechaFinal") String endDate,
            @RequestParam(value = "maximoHuespedes") Integer maximoHuespedes,
            @RequestParam(value = "rating", required = false) Integer rating,Model model) 
    {
    
        if(startDate.equalsIgnoreCase("") ||  endDate.equalsIgnoreCase("")){
            startDate = null;
            endDate = null;
        }
        
        var destinos = destinoService.filtroTotal(precioSup, startDate, endDate, maximoHuespedes, rating);
        model.addAttribute("destinos", destinos);
        model.addAttribute("totalDestinos", destinos.size());
        
        model.addAttribute("precioSup", precioSup);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("maximoHuespedes", maximoHuespedes);
        model.addAttribute("rating", rating);
        return "/destinos/listado";
    }
    
    @PostMapping("/queryLocacion")
    public String consultaLocacion(@RequestParam(value = "locacion") String locacion, Model model) {
        var destinos = destinoService.filtrarLocacion(locacion);
        model.addAttribute("destinos", destinos);
        model.addAttribute("totalDestinos", destinos.size());
        
        model.addAttribute("locacion", locacion);
        return "/destinos/listado";
    }
}

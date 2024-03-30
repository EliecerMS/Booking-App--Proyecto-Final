/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookingapp.controller;
import com.bookingapp.domain.Reserva;
import com.bookingapp.service.ReservaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
 */
@Controller
@Slf4j
@RequestMapping("/reservaciones")
public class ReservacionesController {
    
    @Autowired
    private ReservaService reservaService;

@GetMapping("")
    public String inicio (Model model) {
        model.addAttribute("title", "Reservaciones");
        return "/reservaciones/reservaciones";
    }
    
    @PostMapping("/guardar")
    public String reservaGuardar(Reserva reserva){
            
        reservaService.save(reserva);
        return "redirect:/reservaciones";
    }

}


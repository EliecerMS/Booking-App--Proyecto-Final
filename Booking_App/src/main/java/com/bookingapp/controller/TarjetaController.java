/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookingapp.controller;
import com.bookingapp.domain.Tarjeta;
import com.bookingapp.domain.Usuario;
import java.time.LocalDate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bookingapp.dao.UsuarioDao;
import com.bookingapp.dao.TarjetaDao;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequestMapping("/tarjeta")
public class TarjetaController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private TarjetaDao tarjetaDao;

  

    @PostMapping("/crear")
    public String crearTarjeta(@RequestParam("NombreTarjeta") String nombreTarjeta,
                               @RequestParam("NumeroTarjeta") String numeroTarjeta,
                               @RequestParam("FechaVencimiento") LocalDate fechaVencimiento,
                               @RequestParam("CVC") int cvc,
                               Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        String username = authentication.getName();
        Usuario usuario = usuarioDao.findByUsername(username);
        if (usuario == null) {
            return "redirect:/login";
        }

        Tarjeta tarjeta = new Tarjeta(nombreTarjeta, numeroTarjeta, fechaVencimiento, cvc, usuario);
        tarjetaDao.save(tarjeta);

        return "redirect:/facturacion";
    }
}

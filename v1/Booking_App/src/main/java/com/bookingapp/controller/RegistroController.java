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
 * @author alonso
 */

@Controller
@Slf4j // como se comunica con la base de datos
@RequestMapping("registro")
public class RegistroController {
    
     
    @GetMapping("/registro")
    public String inicio(Model model){
        
        return "registro/registro";
    }
}
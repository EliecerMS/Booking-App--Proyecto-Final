package com.bookingapp.controller;

import com.bookingapp.domain.Usuario;
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
 * @author alonso
 */
@Controller
@Slf4j
@RequestMapping("/perfil")
public class PerfilController {
    
    @GetMapping("")
    public String perfilInicio (Model model) {
        model.addAttribute("title", "Mi perfil");
        return "/perfil/perfil";
    }

}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bookingapp.service;

import com.bookingapp.domain.Usuario;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;


/**
 *
 * @author kenca
 */
public interface RegistroService {

    

    public Model crearUsuario(Model model, Usuario usuario) throws MessagingException;
    
    
    
    public Model recordarUsuario(Model model, Usuario usuario) throws MessagingException;
    
     public Model cambiarContrasennaUsuario(Model model, Usuario usuario) throws MessagingException;
}

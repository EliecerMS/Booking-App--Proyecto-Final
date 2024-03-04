/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookingapp.service.impl;


import com.bookingapp.service.LoginService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eliec
 */
@Service
public class LoginServiceImpl implements LoginService{
    //La anotacion autowired crea un unico objeto mientras se ejecuta la app

    public void getDato(String eldatodeprueba){
        System.out.println("ejemplo de dato" + eldatodeprueba);        
    }

    @Override
    public void getDato() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
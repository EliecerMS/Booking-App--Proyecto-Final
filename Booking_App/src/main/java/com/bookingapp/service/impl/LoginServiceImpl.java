/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookingapp.service.impl;

import com.bookingapp.dao.LoginDao;
import com.bookingapp.domain.Login;
import com.bookingapp.service.LoginService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kenca
 */
@Service
public class LoginServiceImpl implements LoginService{
    //La anotacion autowired crea un unico objeto mientras se ejecuta la app
    @Autowired
    private LoginDao loginDao;
    
    @Override
    public List<Login> getLogin(){
        var lista = loginDao.findAll();
        return lista;
    }
}

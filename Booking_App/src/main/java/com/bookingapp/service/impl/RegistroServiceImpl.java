/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookingapp.service.impl;

import com.bookingapp.dao.RegistroDao;
import com.bookingapp.domain.Registro;
import com.bookingapp.service.RegistroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kenca
 */
@Service
public class RegistroServiceImpl implements RegistroService{
    //La anotacion autowired crea un unico objeto mientras se ejecuta la app
    @Autowired
    private RegistroDao registroDao;
    
    @Override
    public List<Registro> getRegistro(){
        var lista = registroDao.findAll();
        return lista;
    }
}

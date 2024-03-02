/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookingapp.service.impl;

import com.bookingapp.dao.DestinoDao;
import com.bookingapp.domain.Destino;
import com.bookingapp.service.DestinoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eliec
 */
@Service
public class DestinoServiceImpl implements DestinoService{
    //La anotacion autowired crea un unico objeto mientras se ejecuta la app
    @Autowired
    private DestinoDao destinoDao;
    
    @Override
    public List<Destino> getDestinos(){
        var lista = destinoDao.findAll();
        return lista;
    }
}

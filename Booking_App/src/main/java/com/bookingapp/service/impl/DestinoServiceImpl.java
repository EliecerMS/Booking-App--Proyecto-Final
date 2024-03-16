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
import org.springframework.transaction.annotation.Transactional;

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
    
    @Override
    @Transactional(readOnly = true)
    public Destino getDestino(Destino destino) {
        return destinoDao.findById(destino.getIdDestino()).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)    
    public List<Destino> filtrarPrecioNoche(double precioSup) {
        return destinoDao.filtrarPrecioNoche(precioSup);
    }
    
    @Override
    @Transactional(readOnly=true)    
    public List<Destino> filtrarLocacion(String locacion) {
        return destinoDao.filtrarLocacion(locacion);
    }
}

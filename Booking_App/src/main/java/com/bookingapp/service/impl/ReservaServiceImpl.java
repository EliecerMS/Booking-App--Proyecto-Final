/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookingapp.service.impl;

import com.bookingapp.dao.ReservaDao;
import com.bookingapp.domain.Reserva;
import com.bookingapp.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author eliec
 */
@Service
public class ReservaServiceImpl implements ReservaService{
    
    @Autowired
    private ReservaDao reservaDao;
    
    @Override
    @Transactional
    public void save(Reserva reserva) {
        reservaDao.save(reserva);
    }
    
}

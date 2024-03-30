/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bookingapp.service;

import com.bookingapp.domain.Reserva;

/**
 *
 * @author eliec
 */
public interface ReservaService {
    
    // Se inserta una nueva reserva si el id de la reserva esta vacío
    
    public void save(Reserva reserva);
    
}

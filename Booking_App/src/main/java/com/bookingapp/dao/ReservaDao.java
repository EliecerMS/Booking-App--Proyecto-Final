/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bookingapp.dao;

import com.bookingapp.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author eliec
 */
public interface ReservaDao extends JpaRepository<Reserva,Long>{
    
}

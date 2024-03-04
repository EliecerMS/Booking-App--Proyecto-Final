/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bookingapp.dao;

import com.bookingapp.domain.Destino;
import com.bookingapp.domain.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kenca
 */
public interface RegistroDao extends JpaRepository<Registro,Long>{
    
}

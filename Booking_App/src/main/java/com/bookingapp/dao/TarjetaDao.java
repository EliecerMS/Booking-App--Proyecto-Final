/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bookingapp.dao;

import com.bookingapp.domain.Tarjeta;
import com.bookingapp.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kenca
 */
@Repository
public interface TarjetaDao extends JpaRepository<Tarjeta,Long>{
    
}

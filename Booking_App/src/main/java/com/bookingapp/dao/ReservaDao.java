/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bookingapp.dao;

import com.bookingapp.domain.Reserva;
import com.bookingapp.domain.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author eliec
 */
public interface ReservaDao extends JpaRepository<Reserva,Long>{
    List<Reserva> findByUsuario(Usuario usuario);
     Optional<Reserva> findById(Long id);
    
}

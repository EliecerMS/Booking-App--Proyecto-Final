/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bookingapp.dao;

import com.bookingapp.domain.Destino;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author eliec
 */
public interface DestinoDao extends JpaRepository<Destino,Long>{
    
     //Consultas con SQL nativo
    @Query(nativeQuery=true,
            value="SELECT * FROM destino where destino.precio_noche BETWEEN 0 AND :precioSup")
    public List<Destino> filtrarPrecioNoche(@Param("precioSup") double precioSup);
    
     //Consultas con SQL nativo
    @Query(nativeQuery=true, 
            value="SELECT * FROM destino WHERE (destino.pais LIKE %:locacion% OR destino.ciudad LIKE %:locacion%)")
    public List<Destino> filtrarLocacion(@Param("locacion") String locacion);
}

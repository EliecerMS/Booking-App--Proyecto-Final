/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bookingapp.dao;

import com.bookingapp.domain.Destino;
import java.time.LocalDate;
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
    
    
@Query(nativeQuery=true,
       value="SELECT * FROM destino " +
             "WHERE (:precioSup IS NULL OR destino.precio_noche BETWEEN 0 AND :precioSup) " +
             "AND (:startDate IS NULL OR destino.start_date <= :startDate) " +
             "AND (:finalDate IS NULL OR destino.end_date >= :finalDate) " +
             "AND (:cantidadHuespedes IS NULL OR destino.cantidad_huespedes >= :cantidadHuespedes) " +
             "AND (:rating IS NULL OR destino.rating >= :rating)")
public List<Destino> filtroTotal(@Param("precioSup") Double precioSup,
                             @Param("startDate") String startDate,
                             @Param("finalDate") String finalDate,
                             @Param("cantidadHuespedes") Integer cantidadHuespedes,
                             @Param("rating") Integer rating);
}

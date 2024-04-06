/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bookingapp.service;

import com.bookingapp.domain.Destino;
import java.time.LocalDate;
import java.util.List;


/**
 *
 * @author eliec
 */
public interface DestinoService {
    public List<Destino> getDestinos();
    
    
     // Se obtiene un Categoria, a partir del id de un categoria
    public Destino getDestino(Destino destino);
    
    // Filtrar por precio noche
    public List<Destino> filtrarPrecioNoche(double precioSup);
    
    // Filtros totales
    public List<Destino> filtroTotal(double precioSup,
                             String startDate,
                             String endDate,
                             int cantidadHuespedes,
                             int rating);
    
    // Filtrar por locacion
    public List<Destino> filtrarLocacion(String locacion);
}

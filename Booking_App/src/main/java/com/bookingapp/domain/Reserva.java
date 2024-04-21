/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookingapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author eliec
 */

@Data
@Entity
@Table(name="reserva")
public class Reserva {
    
    private static final long serialVersionUID = 1L; // creacion de auto incremental
    
    @Id // para representar que es un primery key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generado como identidad
    @Column(name="id_reserva")//apunta a la columnna en la tabla
    private long idReserva;
    
    private int cantidad_adultos;
    private int cantidad_ninnos;
    private int noches;
    private BigDecimal precio_total;
    
    
    @ManyToOne
    @JoinColumn(name="id_destino")
    Destino destino;
    
    @ManyToOne
    @JoinColumn(name="id_usuario")
    Usuario usuario;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="fechaInicio")
    private Date fechaInicio;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="fechaFinal")
    private Date fechaFinal;


    public Reserva() {
    }

    public Reserva(int cantidad_adultos, int cantidad_ninnos, int noches, BigDecimal precio_total, Date fechaInicio, Date fechaFinal) {
        this.cantidad_adultos = cantidad_adultos;
        this.cantidad_ninnos = cantidad_ninnos;
        this.noches = noches;
        this.precio_total = precio_total;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }
    
    
    
}

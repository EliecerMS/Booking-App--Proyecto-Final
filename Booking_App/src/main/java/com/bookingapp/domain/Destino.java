/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookingapp.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

/**
 *
 * @author eliec
 */

@Data
@Entity
@Table(name="destino")
public class Destino implements Serializable{
    
    private static final long serialVersionUID = 1L; // creacion de auto incremental
    
    @Id // para representar que es un primery key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generado como identidad
    @Column(name="id_destino")//apunta a la columnna en la tabla
    private long idDestino;
    private String nombre_destino;
    private String localizacion;
    private String pais;
    private String ciudad;
    private String ruta_imagen;
    private String descripcion_general;
    private String descripcion_media;
    private BigDecimal precio_noche;
    private String descuento;
    private String descripcion_detalles;
    private String destacado;
    private String inclusion_uno;
    private String inclusion_dos;
    private String inclusion_tres;
    private String exclusion_uno;
    private String exclusion_dos;
    private String exclusion_tres;
    //
    private String condiciones_reembolso;
    private int habitaciones;
    private int cantidad_huespedes;
    private int camas;
    private int bannos;
    private Integer rating;
    private LocalDate start_date;
    private LocalDate end_date;
    

    @OneToMany
    @JoinColumn(name = "id_destino", updatable = false)
    List<Reserva> reservas;
    
    public Destino() {
    }

    public Destino(long idDestino, String nombre_destino, String localizacion, String pais, String ciudad, String ruta_imagen, String descripcion_general, String descripcion_media, BigDecimal precio_noche, String descuento, String descripcion_detalles, String destacado, String inclusion_uno, String inclusion_dos, String inclusion_tres, String exclusion_uno, String exclusion_dos, String exclusion_tres, String condiciones_reembolso, int habitaciones, int cantidad_huespedes, int camas, int bannos, int rating, LocalDate start_date, LocalDate end_date, List<Reserva> reservas) {
        this.idDestino = idDestino;
        this.nombre_destino = nombre_destino;
        this.localizacion = localizacion;
        this.pais = pais;
        this.ciudad = ciudad;
        this.ruta_imagen = ruta_imagen;
        this.descripcion_general = descripcion_general;
        this.descripcion_media = descripcion_media;
        this.precio_noche = precio_noche;
        this.descuento = descuento;
        this.descripcion_detalles = descripcion_detalles;
        this.destacado = destacado;
        this.inclusion_uno = inclusion_uno;
        this.inclusion_dos = inclusion_dos;
        this.inclusion_tres = inclusion_tres;
        this.exclusion_uno = exclusion_uno;
        this.exclusion_dos = exclusion_dos;
        this.exclusion_tres = exclusion_tres;
        this.condiciones_reembolso = condiciones_reembolso;
        this.habitaciones = habitaciones;
        this.cantidad_huespedes = cantidad_huespedes;
        this.camas = camas;
        this.bannos = bannos;
        this.rating = rating;
        this.start_date = start_date;
        this.end_date = end_date;
    }
    
}

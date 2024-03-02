/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookingapp.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
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
    
    private String localizacion;
    private String ruta_imagen;
    private String descripcion_general;
    private String descripcion_media;
    private BigDecimal precio_noche;
    private String descuento;
    

    public Destino() {
    }

    public Destino(long idDestino, String localizacion, String ruta_imagen, String descripcion_general, String descripcion_media, BigDecimal precio_noche, String descuento) {
        this.idDestino = idDestino;
        this.localizacion = localizacion;
        this.ruta_imagen = ruta_imagen;
        this.descripcion_general = descripcion_general;
        this.descripcion_media = descripcion_media;
        this.precio_noche = precio_noche;
        this.descuento = descuento;
    }

    

    
    
    
}

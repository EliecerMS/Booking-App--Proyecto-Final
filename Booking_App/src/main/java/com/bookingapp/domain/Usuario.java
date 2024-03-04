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
 * @author alonso
 * @author kendal
 */

@Data
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L; // creacion de auto incremental
    
    @Id // para representar que es un primery key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generado como identidad
    @Column(name="id_usuario")//apunta a la columnna en la tabla
    private long idUsuario;
    
    private String nombre;
    private String apellidos;
    private String email;
    private String contrasenna;
    private String nombre_usuario;
    

    public Usuario() {
    }

    public Usuario(long idUsuario, String nombre, String apellidos, String email, String contrasenna, String nombre_usuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.contrasenna = contrasenna;
        this.nombre_usuario = nombre_usuario;
    }
    
}

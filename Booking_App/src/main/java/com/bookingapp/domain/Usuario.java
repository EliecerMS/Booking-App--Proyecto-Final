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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author eliec
 */

@Data
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
    
     private static final long serialVersionUID = 1L; // creacion de auto incremental
    
    @Id // para representar que es un primery key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generado como identidad
    @Column(name="id_usuario")//apunta a la columnna en la tabla
    private long idUsuario;
    
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String telefono;
    private String email;
    private String contrasenna;
    private String nombre_usuario;
    
   @OneToMany
   @JoinColumn(name = "id_usuario", updatable = false)
   List<Reserva> reservas;

    public Usuario() {
    }

    public Usuario(String nombre, String primer_apellido, String segundo_apellido, String telefono, String email, String contrasenna, String nombre_usuario, List<Reserva> reservas) {
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.telefono = telefono;
        this.email = email;
        this.contrasenna = contrasenna;
        this.nombre_usuario = nombre_usuario;
        this.reservas = reservas;
    }
   
   
}

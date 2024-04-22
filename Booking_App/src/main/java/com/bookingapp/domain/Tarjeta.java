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
import java.time.LocalDate;

@Entity
public class Tarjeta {

    
     private static final long serialVersionUID = 1L; // creacion de auto incremental
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarjeta;

    private String nombre;
    private String numero;
    
    @Column(name="fecha_vencimiento")
    private LocalDate fechaVencimiento;
    
    private int cvc;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    // Constructores, getters y setters

    public Tarjeta() {
    }

    public Tarjeta(String nombre, String numero, LocalDate fechaVencimiento, int cvc, Usuario usuario) {
        this.nombre = nombre;
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.cvc = cvc;
        this.usuario = usuario;
    }

    
}

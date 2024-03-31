package com.bookingapp.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Alonso Hernandez
 */

    // ---------------------------------------------
    //  este archivo en un contexto MVC
    //  fuciona como el archivo modelo
    //  que se comunica con la base de datos
    // ---------------------------------------------

@Data
@Entity // es una entidad de base de datos
@Table(name="rol")
public class Rol implements Serializable{
    
    // ---------------------------------------------
    // que debe incrementar 1 a 1
    private static final long serialVersionUID = 1L;
    // ---------------------------------------------

    
    // ---------------------------------------------
    @Id // equivalente a decirle que es un primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_rol") // apunta a la columna id_categoria
    private long idRol;
    // ---------------------------------------------
    private String nombre;
    @Column(name="id_usuario")
    private long idUsuario;
    
    
}
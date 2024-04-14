package com.bookingapp.dao;


import com.bookingapp.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Alonso Hernandez
 */
public interface UsuarioDao extends JpaRepository<Usuario,Long>{
    
    // busqueda ampliada
    Usuario findByUsername(String username);
    
    Usuario findByUsernameAndPassword(String username, String Password);

    Usuario findByUsernameOrEmail(String username, String email);

    boolean existsByUsernameOrEmail(String username, String email);
    
}
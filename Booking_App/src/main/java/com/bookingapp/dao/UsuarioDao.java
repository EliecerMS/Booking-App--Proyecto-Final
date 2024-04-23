package com.bookingapp.dao;


import com.bookingapp.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    
    // agregado ----------
    Usuario findByEmailAndTelefono(String email,String telefono);
    

    @Query(nativeQuery=true,
           value="UPDATE usuario SET nombre = :nombre, primer_apellido = :primer_apellido, segundo_apellido = :segundo_apellido,  telefono = :telefono,  email = :email,  username = :username,  ruta_imagen = :ruta_imagen WHERE id_usuario = :idUsuario")
    public void saveUpdate( @Param("idUsuario") long idUsuario,
                            @Param("nombre") String nombre,
                            @Param("primer_apellido") String primer_apellido,
                            @Param("segundo_apellido") String segundo_apellido,
                            @Param("telefono") String telefono,
                            @Param("email") String email,
                            @Param("username") String username,
                            @Param("ruta_imagen") String imagenFile
                          );
}
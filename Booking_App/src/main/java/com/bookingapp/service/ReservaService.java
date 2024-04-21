package com.bookingapp.service;

import com.bookingapp.domain.Reserva;
import com.bookingapp.domain.Usuario;
import java.util.List;

public interface ReservaService {
    
    void save(Reserva reserva);
    
    List<Reserva> obtenerReservasPorUsuario(Usuario usuario);
    
    Reserva obtenerReservaPorId(long id);
    
    void eliminarReservaPorId(long id);
}

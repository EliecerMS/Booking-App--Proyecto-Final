package com.bookingapp.service.impl;

import com.bookingapp.dao.ReservaDao;
import com.bookingapp.domain.Reserva;
import com.bookingapp.domain.Usuario;
import com.bookingapp.service.ReservaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaServiceImpl implements ReservaService {
    
    @Autowired
    private ReservaDao reservaDao;
    
    @Override
    @Transactional
    public void save(Reserva reserva) {
        reservaDao.save(reserva);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Reserva> obtenerReservasPorUsuario(Usuario usuario) {
        return reservaDao.findByUsuario(usuario);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Reserva obtenerReservaPorId(long id) {
        Optional<Reserva> optionalReserva = reservaDao.findById(id);
        return optionalReserva.orElse(null); // O devuelve null si no se encuentra la reserva
    }
    
    @Override
    @Transactional
    public void eliminarReservaPorId(long id) {
        reservaDao.deleteById(id);
    }
}

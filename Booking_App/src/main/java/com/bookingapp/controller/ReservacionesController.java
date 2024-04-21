package com.bookingapp.controller;

import com.bookingapp.domain.Reserva;
import com.bookingapp.domain.Usuario;
import com.bookingapp.service.ReservaService;
import com.bookingapp.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/reservaciones")
public class ReservacionesController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public String mostrarReservaciones(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();

        Usuario usuario = usuarioService.getUsuarioPorUsername(username);

        List<Reserva> reservas = reservaService.obtenerReservasPorUsuario(usuario);

        model.addAttribute("reservas", reservas);
        model.addAttribute("title", "Reservaciones");

        return "/reservaciones/reservaciones";
    }

    @PostMapping("/guardar")
    public String reservaGuardar(Reserva reserva) {
        reservaService.save(reserva);
        return "redirect:/reservaciones";
    }

    @PostMapping("/modifica")
    public String editarReserva(@RequestParam("reservaId") long reservaId,
                                @RequestParam("cantidadAdultos") int cantidadAdultos,
                                @RequestParam("cantidadNinos") int cantidadNinos) {
        Reserva reserva = reservaService.obtenerReservaPorId(reservaId);
        reserva.setCantidad_adultos(cantidadAdultos);
        reserva.setCantidad_ninnos(cantidadNinos);
        reservaService.save(reserva);
        return "redirect:/reservaciones";
    }

    @PostMapping("/eliminar")
    public String eliminarReserva(@RequestParam("reservaId") long reservaId) {
        reservaService.eliminarReservaPorId(reservaId);
        return "redirect:/reservaciones";
    }
}

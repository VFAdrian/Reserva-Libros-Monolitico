package com.reserva.reserva_libros.controller;

import com.reserva.reserva_libros.entity.Reserva;
import com.reserva.reserva_libros.DTO.ReservaRequest;
import com.reserva.reserva_libros.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @PostMapping
    public Reserva reservar(@RequestBody ReservaRequest request) {
        return reservaService.realizarReserva(request);
    }

    @GetMapping
    public List<Reserva> listar() {
        return reservaService.listarReservas();
    }

    @DeleteMapping("/{id}")
    public String cancelarReserva(@PathVariable Long id) {
        reservaService.cancelarReserva(id);
        return "Reserva cancelada correctamente";
    }

}

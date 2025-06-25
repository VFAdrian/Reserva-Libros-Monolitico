package com.reserva.reserva_libros.service;

import com.reserva.reserva_libros.entity.Libro;
import com.reserva.reserva_libros.entity.Reserva;
import com.reserva.reserva_libros.entity.Usuario;
import com.reserva.reserva_libros.DTO.ReservaRequest;
import com.reserva.reserva_libros.repository.LibroRepository;
import com.reserva.reserva_libros.repository.ReservaRepository;
import com.reserva.reserva_libros.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final LibroRepository libroRepository;
    private final UsuarioRepository usuarioRepository;

    public Reserva realizarReserva(ReservaRequest request) {
        Libro libro = libroRepository.findById(request.getLibroId())
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!libro.isDisponible()) {
            throw new RuntimeException("El libro no está disponible");
        }

        libro.setDisponible(false);
        libroRepository.save(libro);

        return reservaRepository.save(Reserva.builder()
                .libro(libro)
                .usuario(usuario)
                .fechaReserva(LocalDate.now())
                .build());
    }

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public void cancelarReserva(Long reservaId) {
        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        Libro libro = reserva.getLibro();
        libro.setDisponible(true);
        libroRepository.save(libro); //libro disponible nuevamente

        reservaRepository.deleteById(reservaId);
    }


}

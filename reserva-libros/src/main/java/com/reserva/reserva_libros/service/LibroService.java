package com.reserva.reserva_libros.service;

import com.reserva.reserva_libros.entity.Libro;
import com.reserva.reserva_libros.DTO.LibroRequest;
import com.reserva.reserva_libros.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibroService {

    private final LibroRepository libroRepository;

    public Libro registrarLibro(LibroRequest request) {
        return libroRepository.save(Libro.builder()
                .titulo(request.getTitulo())
                .autor(request.getAutor())
                .disponible(true)
                .build());
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

}

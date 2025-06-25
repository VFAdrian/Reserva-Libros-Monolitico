package com.reserva.reserva_libros.controller;

import com.reserva.reserva_libros.entity.Libro;
import com.reserva.reserva_libros.DTO.LibroRequest;
import com.reserva.reserva_libros.service.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
@RequiredArgsConstructor
public class LibroController {

    private final LibroService libroService;

    @PostMapping
    public Libro registrar(@RequestBody LibroRequest request) {
        return libroService.registrarLibro(request);
    }

    @GetMapping
    public List<Libro> listar() {
        return libroService.listarLibros();
    }

}

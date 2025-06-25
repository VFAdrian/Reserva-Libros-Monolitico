package com.reserva.reserva_libros.controller;

import com.reserva.reserva_libros.entity.Usuario;
import com.reserva.reserva_libros.DTO.UsuarioRequest;
import com.reserva.reserva_libros.repository.UsuarioRepository;
import com.reserva.reserva_libros.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;

    @PostMapping
    public Usuario registrar(@RequestBody UsuarioRequest request) {
        return usuarioService.registrarUsuario(request);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}

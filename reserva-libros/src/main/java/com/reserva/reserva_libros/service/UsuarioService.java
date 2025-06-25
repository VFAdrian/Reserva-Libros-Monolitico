package com.reserva.reserva_libros.service;

import com.reserva.reserva_libros.entity.Usuario;
import com.reserva.reserva_libros.DTO.UsuarioRequest;
import com.reserva.reserva_libros.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(UsuarioRequest request) {
        return usuarioRepository.save(Usuario.builder()
                .nombre(request.getNombre())
                .build());
    }

}

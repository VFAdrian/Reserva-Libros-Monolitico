package com.reserva.reserva_libros.repository;

import com.reserva.reserva_libros.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

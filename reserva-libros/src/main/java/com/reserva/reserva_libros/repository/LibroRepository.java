package com.reserva.reserva_libros.repository;

import com.reserva.reserva_libros.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}

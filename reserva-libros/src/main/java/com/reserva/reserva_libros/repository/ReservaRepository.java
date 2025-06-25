package com.reserva.reserva_libros.repository;

import com.reserva.reserva_libros.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}

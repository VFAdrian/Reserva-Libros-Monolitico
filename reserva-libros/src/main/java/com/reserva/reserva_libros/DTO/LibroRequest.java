package com.reserva.reserva_libros.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroRequest {

    private String titulo;
    private String autor;
}

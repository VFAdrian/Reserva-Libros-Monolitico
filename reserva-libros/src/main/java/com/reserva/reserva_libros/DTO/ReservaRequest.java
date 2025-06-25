package com.reserva.reserva_libros.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaRequest {

    private Long libroId;
    private Long usuarioId;
}

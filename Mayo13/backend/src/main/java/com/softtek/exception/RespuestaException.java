package com.softtek.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RespuestaException {
    private LocalDateTime fecha;
    private String mensaje;
    private String descripcion;
}

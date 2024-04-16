package com.softtek.Abril16.ejercicio1.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Saludo {
    private String mensaje = "Hola mundo";
}

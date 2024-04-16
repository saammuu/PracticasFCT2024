package com.softtek.Abril16.ejercicio5.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private String nombre;
    private String NIF;
}

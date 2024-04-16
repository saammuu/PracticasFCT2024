package com.softtek.Abril16.ejercicio3.modelo;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class TallerPintura implements ITaller{
    @Override
    public String reparar(Coche c) {
        return "Pintando el coche con matricula: " + c.getMatricula() + ", modelo: " + c.getModelo();
    }
}

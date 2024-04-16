package com.softtek.Abril16.ejercicio3.modelo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TallerMecanica implements ITaller{
    @Override
    public String reparar(Coche c) {
        return "Reparando el coche con matricula: " + c.getMatricula() + ", modelo: " + c.getModelo();
    }
}

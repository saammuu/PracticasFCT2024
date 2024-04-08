package com.softtek.clases.abstractas.ejercicios.ejercicio4.modelo;

public class TallerPintura implements ITaller{
    public TallerPintura() {
    }

    @Override
    public String reparar(Coche c) {
        return "Pintando el coche con matricula: " + c.getMatricula() + ", modelo: " + c.getModelo();
    }
}

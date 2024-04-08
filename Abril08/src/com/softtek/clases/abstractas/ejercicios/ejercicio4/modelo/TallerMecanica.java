package com.softtek.clases.abstractas.ejercicios.ejercicio4.modelo;

public class TallerMecanica implements ITaller{
    public TallerMecanica() {
    }

    @Override
    public String reparar(Coche c) {
        return "Reparando el coche con matricula: " + c.getMatricula() + ", modelo: " + c.getModelo();
    }
}

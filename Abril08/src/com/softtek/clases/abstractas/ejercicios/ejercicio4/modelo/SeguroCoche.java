package com.softtek.clases.abstractas.ejercicios.ejercicio4.modelo;

public class SeguroCoche {
    private ITaller taller;
    private String aseguradora;

    public SeguroCoche() {
    }

    public SeguroCoche(ITaller taller, String aseguradora) {
        this.taller = taller;
        this.aseguradora = aseguradora;
    }

    public String reparar (Coche c){
        return taller.reparar(c);
    }

}

package com.softtek.herencia.ejercicios.ejercicio4.modelo;

public class Bateria extends InstrumentoMusical{
    private int noPalillos;

    public Bateria() {
    }

    public Bateria(String marca, int noPalillos) {
        super(marca);
        this.noPalillos = noPalillos;
    }

    public int getNoPalillos() {
        return noPalillos;
    }

    public void setNoPalillos(int noPalillos) {
        this.noPalillos = noPalillos;
    }

    @Override
    public String emitirSonido() {
        return "Soy una bateria";
    }

    @Override
    public String toString() {
        return "Bateria{" +
                "noPalillos=" + noPalillos +
                ", marca='" + marca + '\'' +
                '}';
    }
}

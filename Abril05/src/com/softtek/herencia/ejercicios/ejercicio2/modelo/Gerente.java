package com.softtek.herencia.ejercicios.ejercicio2.modelo;

public class Gerente extends Empleado{
    private double bono;

    public Gerente() {
    }

    public Gerente(String nombre, double sueldo, double bono) {
        super(nombre, sueldo);
        this.bono = bono;
    }

    @Override
    public double calcularNomina() {
        return (super.getSueldo() + this.bono) * super.getPORCENTAJE();
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "nombre='" + nombre + '\'' +
                ", sueldo=" + sueldo +
                ", PORCENTAJE=" + PORCENTAJE +
                ", bono=" + bono +
                '}';
    }
}

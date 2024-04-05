package com.softtek.herencia.ejercicios.ejercicio2.modelo;

public class Vendedor extends Empleado{
    private double ventas;
    private double comision;

    public Vendedor() {
    }

    public Vendedor(String nombre, double sueldo, double ventas, double comision) {
        super(nombre, sueldo);
        this.ventas = ventas;
        this.comision = comision;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    @Override
    public double calcularNomina() {
        return (this.ventas * this.comision + super.getSueldo()) * super.getPORCENTAJE();
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "nombre='" + nombre + '\'' +
                ", sueldo=" + sueldo +
                ", PORCENTAJE=" + PORCENTAJE +
                ", ventas=" + ventas +
                ", comision=" + comision +
                '}';
    }
}

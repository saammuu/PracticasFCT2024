package com.softtek.herencia.ejercicios.ejercicio1.modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ProductoPerecedero extends Producto{
    private LocalDate fCaducidad;
    private LocalDate fFabricacion;


    public ProductoPerecedero(String nombre, int cantidad, double pvp, LocalDate fCaducidad, LocalDate fFabricacion) {
        super(nombre, cantidad, pvp);
        this.fCaducidad = fCaducidad;
        this.fFabricacion = fFabricacion;
    }

    public LocalDate getfCaducidad() {
        return fCaducidad;
    }

    public void setfCaducidad(LocalDate fCaducidad) {
        this.fCaducidad = fCaducidad;
    }

    public LocalDate getfFabricacion() {
        return fFabricacion;
    }

    public void setfFabricacion(LocalDate fFabricacion) {
        this.fFabricacion = fFabricacion;
    }

    public long tiempoConsumicion(){
        return fFabricacion.until(fCaducidad, ChronoUnit.DAYS);
    }

    @Override
    public String toString() {
        return "ProductoPerecedero{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", pvp=" + pvp +
                ", fCaducidad=" + fCaducidad +
                ", fFabricacion=" + fFabricacion +
                '}';
    }
}

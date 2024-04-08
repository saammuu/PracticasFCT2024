package com.softtek.clases.abstractas.ejercicios.ejercicio3.modelo;

public class Conductor {
    private IVehiculo vehiculo;

    public Conductor(IVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String conducir(){
        return "Conduciendo...";
    }


}

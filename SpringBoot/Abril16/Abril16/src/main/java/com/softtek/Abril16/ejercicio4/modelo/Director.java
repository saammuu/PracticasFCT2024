package com.softtek.Abril16.ejercicio4.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Director implements Empleado{
    @Autowired
    private Informe informe;

    public Director(Informe informe) {
        this.informe = informe;
    }

    @Override
    public String getTareas() {
        return "Obteniendo tareas para el Director...";
    }

    @Override
    public String getInformes() {
        return "Obteniendo informes del Director: "+ informe.getInforme();
    }
}

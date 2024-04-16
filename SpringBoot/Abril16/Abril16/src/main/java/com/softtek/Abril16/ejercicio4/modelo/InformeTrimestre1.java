package com.softtek.Abril16.ejercicio4.modelo;

import org.springframework.stereotype.Component;

@Component
public class InformeTrimestre1 implements Informe{
    public InformeTrimestre1() {
    }

    @Override
    public String getInforme() {
        return "Informes del Trimestre 1";
    }
}

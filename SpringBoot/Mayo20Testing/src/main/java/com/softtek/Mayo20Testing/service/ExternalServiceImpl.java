package com.softtek.Mayo20Testing.service;

import com.softtek.Mayo20Testing.model.Mascota;

public class ExternalServiceImpl implements ExternalService{

    @Override
    public boolean validarVacunas(Mascota mascota) {
        return !mascota.getNombre().contains("sin vacuna");
    }

    @Override
    public boolean verificarRegistroMunicipal(Mascota mascota) {
        return !mascota.getNombre().contains("no registrado");
    }
}


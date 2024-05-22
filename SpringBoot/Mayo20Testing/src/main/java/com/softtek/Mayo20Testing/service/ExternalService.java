package com.softtek.Mayo20Testing.service;


import com.softtek.Mayo20Testing.model.Mascota;

public interface ExternalService {

    boolean validarVacunas(Mascota mascota);
    boolean verificarRegistroMunicipal(Mascota mascota);
}

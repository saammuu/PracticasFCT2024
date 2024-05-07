package com.softtek.services;

import com.softtek.models.Lugar;
import com.softtek.repositories.IGenericoRepositorio;
import com.softtek.repositories.ILugarRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LugarServicioImpl extends  CRUDImpl<Lugar, Integer> implements ILugarServicio{

    @Autowired
    private ILugarRepositorio lugarRepositorio;

    @Override
    protected IGenericoRepositorio<Lugar, Integer> getRepo() {
        return lugarRepositorio;
    }
}

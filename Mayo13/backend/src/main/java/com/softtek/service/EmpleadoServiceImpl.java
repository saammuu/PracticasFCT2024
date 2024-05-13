package com.softtek.service;

import com.softtek.model.Empleado;
import com.softtek.repository.IEmpleadoRepositorio;
import com.softtek.repository.IGenericoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl extends CRUDImpl <Empleado, Integer> implements IEmpleadoService{

    @Autowired
    private IEmpleadoRepositorio repositorio;
    @Override
    protected IGenericoRepositorio<Empleado, Integer> getRepo() {
        return repositorio;
    }
}

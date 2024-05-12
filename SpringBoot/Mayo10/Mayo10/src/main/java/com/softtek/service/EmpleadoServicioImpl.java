package com.softtek.service;

import com.softtek.model.Empleado;
import com.softtek.repository.IEmpleadoRepo;
import com.softtek.repository.IGenericoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicioImpl extends CRUDImpl<Empleado,Integer> implements IEmpleadoServicio {
    @Autowired
    private IEmpleadoRepo repo;
    @Override
    protected IGenericoRepositorio<Empleado, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Object[]> obtenerResumenes() {
        return repo.obtenerResumenes();
    }
}

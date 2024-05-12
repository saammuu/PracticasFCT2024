package com.softtek.service;

import com.softtek.model.Empleado;

import java.util.List;

public interface IEmpleadoServicio extends ICRUD<Empleado,Integer> {
    public List<Object[]> obtenerResumenes();
}

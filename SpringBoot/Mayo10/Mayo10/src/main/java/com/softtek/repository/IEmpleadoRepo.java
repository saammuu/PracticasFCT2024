package com.softtek.repository;

import com.softtek.model.Empleado;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmpleadoRepo extends IGenericoRepositorio<Empleado, Integer>{
    @Query(value = "Select count(id_empleado) as contador, avg(sueldo) as sueldo_promedio from empleados;",nativeQuery = true)
    public List<Object[]> obtenerResumenes();
}

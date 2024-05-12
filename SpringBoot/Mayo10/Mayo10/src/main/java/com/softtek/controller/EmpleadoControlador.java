package com.softtek.controller;
import com.softtek.dto.EmpleadoDTO;
import com.softtek.exceptions.NoEncontrado;
import com.softtek.model.Empleado;
import com.softtek.service.IEmpleadoServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoControlador {

    @Autowired
    private IEmpleadoServicio servicio;
    @PostMapping
    public ResponseEntity<EmpleadoDTO>  crearEmpleado(@Valid @RequestBody EmpleadoDTO e){
        Empleado e1 = e.castEmpleado();
        e1 = servicio.crear(e1);
        return new ResponseEntity<>(e.castEmpleadoADto(e1), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EmpleadoDTO>  modificarEmpleado(@Valid @RequestBody EmpleadoDTO e){

        Empleado e1 = servicio.consultarUno(e.getIdEmpleado());
        if(e1 == null){
            throw new NoEncontrado("EMPLEADO NO ENCONTRADO " + e.getIdEmpleado());
        }
        e1 = servicio.modificar(e.castEmpleado());
        return new ResponseEntity<>(e.castEmpleadoADto(e1), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> consultarUno(@PathVariable(name="id") Integer id){
        Empleado e1 = servicio.consultarUno(id);
        if(e1 == null){
            throw new NoEncontrado("EMPLEADO NO ENCONTRADO " + id);
        }
        return new ResponseEntity<>((new EmpleadoDTO()).castEmpleadoADto(e1),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable(name="id") Integer id){
        Empleado e1 = servicio.consultarUno(id);
        if(e1 == null){
            throw new NoEncontrado("EMPLEADO NO ENCONTRADO " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> consultarTodos(){
        List<Empleado> empleadosBBDD = servicio.consultarTodos();
        List<EmpleadoDTO> empleadosDto = new ArrayList<>();
        for (Empleado elemento:
                empleadosBBDD) {
            EmpleadoDTO eDto = new EmpleadoDTO();
            empleadosDto.add(eDto.castEmpleadoADto(elemento));
        }
        return new ResponseEntity<>(empleadosDto,HttpStatus.OK);

    }


}

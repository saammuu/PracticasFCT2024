package com.softtek.controller;

import com.softtek.dto.EmpleadoDTO;
import com.softtek.exception.NoEncontradoException;
import com.softtek.model.Empleado;
import com.softtek.service.IEmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empleados")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoController {

    @Autowired
    private IEmpleadoService servicio;

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> consultarTodos(){
        List<Empleado> empleadosBBDD = servicio.consultaTodos();
        List<EmpleadoDTO> empleadosDto = new ArrayList<>();
        for (Empleado e:empleadosBBDD) {
            EmpleadoDTO eDto = new EmpleadoDTO();
            empleadosDto.add(eDto.castToDTO(e));
        }
        return new ResponseEntity<>(empleadosDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> consultarUno(@PathVariable(name="id") Integer id){
        Empleado e1 = servicio.consultaUno(id);
        if(e1 == null){
            throw new NoEncontradoException("EMPLEADO NO ENCONTRADO " + id);
        }
        return new ResponseEntity<>((new EmpleadoDTO()).castToDTO(e1),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmpleadoDTO>  crearEmpleado(@Valid @RequestBody EmpleadoDTO e){
        Empleado e1 = e.castToEmpleado();
        e1 = servicio.crear(e1);
        return new ResponseEntity<>(e.castToDTO(e1), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable(name="id") Integer id){
        Empleado e1 = servicio.consultaUno(id);
        if(e1 == null){
            throw new NoEncontradoException("EMPLEADO NO ENCONTRADO " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

   // TODO: Hacer modificar si es necesario para el ejemplo
   @PutMapping
   public ResponseEntity<EmpleadoDTO>  modificarEmpleado(@Valid @RequestBody EmpleadoDTO e){

       Empleado e1 = servicio.consultaUno(e.getIdEmpleado());
       if(e1 == null){
           throw new NoEncontradoException("EMPLEADO NO ENCONTRADO " + e.getIdEmpleado());
       }
       e1 = servicio.modificar(e.castToEmpleado());
       return new ResponseEntity<>(e.castToDTO(e1), HttpStatus.OK);
   }
}

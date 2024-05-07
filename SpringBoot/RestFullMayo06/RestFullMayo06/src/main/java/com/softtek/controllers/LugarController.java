package com.softtek.controllers;

import com.softtek.models.Lugar;
import com.softtek.models.Producto;
import com.softtek.services.ILugarServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lugares")
public class LugarController {
    @Autowired
    public ILugarServicio servicio;

    @GetMapping
    public ResponseEntity<List<Lugar>> consultarTodos(){
        return new ResponseEntity<>(servicio.consultarTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Lugar> crear(@RequestBody Lugar l) {
        Lugar pBBDD = servicio.crear(l);
        return new ResponseEntity<>(pBBDD, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lugar> consultarUno(@PathVariable("id") int id){
        Lugar cm = servicio.consultaUno(id);
/*        if(cm == null) {
            throw new ExcepcionNoEncontrado("recurso no encontrado " + id);

        }*/
        return new ResponseEntity<>(cm, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Lugar> modificar(@RequestBody Lugar t) {
        Lugar lBBDD = servicio.consultaUno(t.getIdLugar());
/*        if (pBBDD == null) {
            throw new ExcepcionNoEncontrado("recurso no encontrado " + p.getIdPaciente());
        }*/
        return new ResponseEntity<>(servicio.modificar(t), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

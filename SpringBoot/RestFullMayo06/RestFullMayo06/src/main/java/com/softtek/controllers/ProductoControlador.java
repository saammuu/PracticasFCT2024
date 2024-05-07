package com.softtek.controllers;

import com.softtek.models.Producto;
import com.softtek.services.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoControlador {

    @Autowired
    private IProductoServicio servicio;

    @GetMapping
    public ResponseEntity<List<Producto>> consultarTodos(){
        return new ResponseEntity<>(servicio.consultarTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto p) {
        Producto pBBDD = servicio.crear(p);
        return new ResponseEntity<>(pBBDD, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> consultarUno(@PathVariable("id") int id){
        Producto cm = servicio.consultaUno(id);
/*        if(cm == null) {
            throw new ExcepcionNoEncontrado("recurso no encontrado " + id);

        }*/
        return new ResponseEntity<>(cm, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<Producto> modificar(@RequestBody Producto p) {
        Producto pBBDD = servicio.consultaUno(p.getIdProducto());
/*        if (pBBDD == null) {
            throw new ExcepcionNoEncontrado("recurso no encontrado " + p.getIdPaciente());
        }*/
        return new ResponseEntity<>(servicio.modificar(p), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

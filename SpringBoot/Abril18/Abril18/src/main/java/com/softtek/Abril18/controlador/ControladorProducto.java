package com.softtek.Abril18.controlador;

import com.softtek.Abril18.modelo.Producto;
import com.softtek.Abril18.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ControladorProducto {
    @Autowired
    private IProductoServicio servicio;

    @GetMapping
    public List<Producto> obtenerProductos(){
        try {
            return servicio.obtenerProductos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable int id){
        try {
            return servicio.obtenerProductoPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto p){
        try {
            return servicio.crearProducto(p);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //@DeleteMapping("/{id}")
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable int id){
        try {
            servicio.eliminarProducto(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping
    public Producto modificarProducto(@RequestBody Producto p){
        try {
            return servicio.modificarProducto(p);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

package com.softtek.clases.abstractas.ejercicios.ejercicio8.modelo;

import com.softtek.clases.abstractas.ejercicios.ejercicio8.ProductoException;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private String proveedor;
    private String descripcion;

    public Producto() {
    }

    public Producto(int id, String nombre, double precio, String proveedor, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.proveedor = proveedor;
        this.descripcion = descripcion;
    }

    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void comprobar() throws ProductoException {
        if (id <= 0){
            throw new ProductoException("El id del producto no está definido");
        }
    }
}

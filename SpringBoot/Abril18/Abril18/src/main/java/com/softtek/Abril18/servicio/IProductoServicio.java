package com.softtek.Abril18.servicio;

import com.softtek.Abril18.modelo.Producto;

import java.sql.SQLException;
import java.util.List;

public interface IProductoServicio {
    List<Producto> obtenerProductos() throws SQLException, ClassNotFoundException;
    Producto obtenerProductoPorId(int id) throws SQLException, ClassNotFoundException;
    Producto crearProducto(Producto p) throws SQLException, ClassNotFoundException;
    void eliminarProducto(int id) throws SQLException, ClassNotFoundException;
    Producto modificarProducto(Producto p) throws SQLException, ClassNotFoundException;
}

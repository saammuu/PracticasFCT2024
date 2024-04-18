package com.softtek.Abril18.servicio;

import com.softtek.Abril18.modelo.Producto;
import com.softtek.Abril18.repo.IProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio{
    @Autowired
    private IProductoRepo repo;

    @Override
    public List<Producto> obtenerProductos() throws SQLException, ClassNotFoundException {
        return repo.obtenerProductos();
    }

    @Override
    public Producto obtenerProductoPorId(int id) throws SQLException, ClassNotFoundException {
        return repo.obtenerProductoPorId(id);
    }

    @Override
    public Producto crearProducto(Producto p) throws SQLException, ClassNotFoundException {
        return repo.crearProducto(p);
    }

    @Override
    public void eliminarProducto(int id) throws SQLException, ClassNotFoundException {
        repo.eliminarProducto(id);
    }

    @Override
    public Producto modificarProducto(Producto p) throws SQLException, ClassNotFoundException {
        return repo.modificarProducto(p);
    }
}

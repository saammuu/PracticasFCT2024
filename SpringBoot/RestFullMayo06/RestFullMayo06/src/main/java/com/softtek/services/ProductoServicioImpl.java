package com.softtek.services;

import com.softtek.models.Producto;
import com.softtek.repositories.IGenericoRepositorio;
import com.softtek.repositories.IProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicioImpl extends CRUDImpl<Producto, Integer> implements IProductoServicio{
    @Autowired
    private IProductoRepositorio productoRepositorio;

    @Override
    protected IGenericoRepositorio<Producto, Integer> getRepo() {
        return productoRepositorio;
    }
}

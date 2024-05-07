package com.softtek.repositories;

import com.softtek.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepositorio extends IGenericoRepositorio<Producto, Integer> {
}

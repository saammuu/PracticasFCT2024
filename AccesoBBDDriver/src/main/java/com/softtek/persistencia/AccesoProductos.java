package com.softtek.persistencia;

import com.softtek.modelo.Producto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoProductos extends Conexion{
    public List<Producto> obtenerTodos() throws SQLException, ClassNotFoundException {
        Statement sentencia;
        ResultSet resultado;
        String sql = """
            SELECT product_id, product_name, unit_price, units_in_stock FROM products;
            """;
        List<Producto> productos = new ArrayList<>();
        abrirConexion();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        while (resultado.next()){
            productos.add(
                    new Producto(
                            resultado.getInt("product_id"),
                            resultado.getString("product_name"),
                            resultado.getDouble("unit_price"),
                            resultado.getInt("units_in_stock")
                    )
            );
        }
        return productos;
    }
    //Obtener 1 -> parametro un id
    public Producto obtenerProductoPorId(int id) throws SQLException, ClassNotFoundException {
        Statement sentencia;
        ResultSet resultado;
        String sql = "SELECT product_id, product_name, unit_price, units_in_stock FROM products WHERE product_id = " + id;
        Producto producto = null;
        abrirConexion();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        if (resultado.next()) {
            producto = new Producto(
                    resultado.getInt("product_id"),
                    resultado.getString("product_name"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("units_in_stock")
            );
        }
        return producto;
    }


    public void crear(Producto p1) throws SQLException, ClassNotFoundException {
        abrirConexion();
        Statement sentencia;

        String sql = "INSERT INTO products(product_id, product_name, unit_price, units_in_stock, discontinued) VALUES (" + p1.getIdProducto() + ", '" + p1.getNombreProducto() + "',"
                +p1.getPrecioUnitario() + "," + p1.getUnidadesStock() + ",0)";
        sentencia = miConexion.createStatement();
        sentencia.executeUpdate(sql);
        System.out.println("Producto añadido");
    }
    public void delete(int productId) throws SQLException, ClassNotFoundException {
        abrirConexion();
        Statement sentencia;

        String sql = "DELETE FROM products WHERE product_id = " + productId;
        sentencia = miConexion.createStatement();
        sentencia.executeUpdate(sql);
        System.out.println("ELIMINADO CON EXITO");
    }
    //Modificar el objeto producto entero como parametro
    public void update(int productId, String nuevoNombre) throws SQLException, ClassNotFoundException {
        abrirConexion();
        Statement sentencia;

        String sql = "UPDATE products SET product_name = '" + nuevoNombre + "' WHERE product_id = " + productId;
        sentencia = miConexion.createStatement();
        sentencia.executeUpdate(sql);
        System.out.println("MODIFICADO CORRECTAMENTE");
    }



}

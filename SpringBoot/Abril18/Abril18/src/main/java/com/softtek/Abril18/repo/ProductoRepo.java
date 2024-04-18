package com.softtek.Abril18.repo;

import com.softtek.Abril18.modelo.Producto;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepo extends Conexion implements IProductoRepo{
    @Override
    public List<Producto> obtenerProductos() throws SQLException, ClassNotFoundException {
        List<Producto> productos = new ArrayList<>();
        Statement sentencia;
        ResultSet resultado;

        String sql = """
                SELECT product_id, product_name, unit_price, discontinued FROM products
                """;
        abrirConexion();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        while (resultado.next()) {
            int idProducto = resultado.getInt("product_id");
            String nombreProducto = resultado.getString("product_name");
            double precioUnitario = resultado.getDouble("unit_price");
            int discontinuado = resultado.getInt("discontinued");

            Producto producto = new Producto(idProducto, nombreProducto, precioUnitario, discontinuado);
            productos.add(producto);
        }

        return productos;
    }

    @Override
    public Producto obtenerProductoPorId(int id) throws SQLException, ClassNotFoundException {
        Statement sentencia;
        ResultSet resultado;
        String sql = "SELECT product_id, product_name, unit_price, discontinued FROM products WHERE product_id = " + id;
        Producto producto = null;
        abrirConexion();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        if (resultado.next()) {
            producto = new Producto(
                    resultado.getInt("product_id"),
                    resultado.getString("product_name"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("discontinued")
            );
        }
        return producto;
    }

    @Override
   public Producto crearProducto(Producto p) throws SQLException, ClassNotFoundException {
        abrirConexion();
        String sql = "INSERT INTO products (product_id, product_name, unit_price, discontinued) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = miConexion.prepareStatement(sql);

        ps.setInt(1, p.getIdProducto());
        ps.setString(2, p.getNombreProducto());
        ps.setDouble(3, p.getPrecioUnitario());
        ps.setInt(4, p.getDiscontinuado());

        if ( ps.executeUpdate() > 0 ) {
            return p;
        } else {
            return null;
        }
    }

    @Override
    public void eliminarProducto(int id) throws SQLException, ClassNotFoundException {
        abrirConexion();
        Statement sentencia;

        String sql = "DELETE FROM products WHERE product_id = " + id;
        sentencia = miConexion.createStatement();
        sentencia.executeUpdate(sql);
    }

    @Override
    public Producto modificarProducto(Producto p) throws SQLException, ClassNotFoundException {
       String sql = """
               UPDATE products SET product_name = ?, unit_price = ?, discontinued = ? WHERE product_id = ?
               """;
        abrirConexion();
        PreparedStatement sentencia = miConexion.prepareStatement(sql);
        sentencia.setString(1, p.getNombreProducto());
        sentencia.setDouble(2, p.getPrecioUnitario());
        sentencia.setInt(3, p.getDiscontinuado());
        sentencia.setInt(4, p.getIdProducto());
        if(sentencia.executeUpdate() >0){
            return p;
        }else{
            return null;
        }
    }
}

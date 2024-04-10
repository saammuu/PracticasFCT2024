package com.softtek.presentacion;

import com.softtek.modelo.Producto;
import com.softtek.persistencia.AccesoProductos;
import com.softtek.persistencia.Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccesoProductos acp = new AccesoProductos();
        Scanner sc = new Scanner(System.in);

        List<String> opciones = List.of("1. Ver Productos", "2. Añadir Productos", "3. Eliminar Producto", "4. Modificar nombre producto","5. Mostrar producto por ID", "6. Salir");

        while (true){
            System.out.println(opciones);
            switch (sc.nextInt()){
                case 1:
                    try {
                        acp.obtenerTodos().forEach(System.out::println);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("ID del producto: ");
                    int id = sc.nextInt();
                    System.out.println("Nombre del producto: ");
                    String nombre =  sc.next();
                    System.out.println("Precio Unitario: ");
                    double precio = sc.nextDouble();
                    System.out.println("Unidades en stock: ");
                    int unidades = sc.nextInt();
                    Producto p = new Producto(id,nombre,precio,unidades);
                    try {
                        acp.crear(p);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("ID del elemento a eliminar: ");
                    int idp = sc.nextInt();
                    try {
                        acp.delete(idp);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("ID del producto a modificar: ");
                    int idm = sc.nextInt();
                    System.out.println("Nuevo nombre a modificar: ");
                    String nombreM = sc.next();
                    try {
                        acp.update(idm,nombreM);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("ID del producto a modificar: ");
                    int idU = sc.nextInt();
                    try {
                        System.out.println(acp.obtenerProductoPorId(idU));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("CERRANDO!!!!");
                    return;

            }
        }

    }


}

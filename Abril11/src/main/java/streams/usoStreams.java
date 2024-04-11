package streams;

import modelo.Empleado;
import modelo.EmpleadoStream;
import modelo.Producto;

import persistencia.AccesoEmpleados;
import persistencia.AccesoProductos;
import persistencia.Conexion;
import persistencia.EmpleadoSQL;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class usoStreams extends Conexion {
    public static void main(String[] args) {
        AccesoEmpleados emp = new AccesoEmpleados();
        AccesoProductos prod = new AccesoProductos();
        List<EmpleadoStream> empleados;
        List<Producto> productos;
        try {
            empleados = emp.obtenerTodos();
            productos = prod.obtenerTodos();
            // 1.
            System.out.println("EJERCICIO 1");
            List<Producto> productosCat2 = productos.stream()
                    .filter(producto -> producto.getCategoria() == 2)
                    .collect(Collectors.toList());
            System.out.println("Solucion ejercicio 1 : \n" + productosCat2);

            // 2.
            System.out.println("EJERCICIO 2");
            List<Producto> productosComienzanConN = productos.stream()
                    .filter(producto -> producto.getNombreProducto().startsWith("N"))
                    .collect(Collectors.toList());
            System.out.println("Solucion ejercicio 2 : \n" + productosComienzanConN);

            // 3.
            System.out.println("EJERCICIO 3");
            List<Producto> productosOrdenadosPorNombre = productos.stream()
                    .sorted(Comparator.comparing(Producto::getNombreProducto))
                    .collect(Collectors.toList());
            System.out.println("Solucion ejercicio 3 : \n" + productosOrdenadosPorNombre);

            // 4.
            System.out.println("EJERCICIO 4");
            Optional<Producto> productoPrecioMaximo = productos.stream()
                    .max(Comparator.comparing(Producto::getPrecioUnitario));
            productoPrecioMaximo.ifPresent(producto -> System.out.println("Producto con precio máximo: " + producto));

            // 5.
            System.out.println("EJERCICIO 5");
            Double promedioPrecioProductos = productos.stream()
                    .mapToDouble(Producto::getPrecioUnitario)
                    .average()
                    .orElse(Double.NaN);
            if (!Double.isNaN(promedioPrecioProductos)) {
                System.out.println("Promedio del precio de productos: " + promedioPrecioProductos);
            } else {
                System.out.println("No hay productos para calcular el promedio.");
            }
            // 6.
            System.out.println("EJERCICIO 6");
            LocalDate fechaActual = LocalDate.now();
            List<EmpleadoStream> empleadosJubilados = empleados.stream()
                    .filter(empleado -> ChronoUnit.YEARS.between(empleado.getNacimiento(), fechaActual) > 68)
                    .collect(Collectors.toList());
            System.out.println("Solucion ejercicio 6 : \n" + empleadosJubilados);

            // 7.
            System.out.println("EJERCICIO 7");
            Map<Integer, Long> categoriasYCantidadProductos = productos.stream()
                    .collect(Collectors.groupingBy(Producto::getCategoria, Collectors.counting()));
            System.out.println("Categorías y cantidad de productos: " + categoriasYCantidadProductos);

            // 8.
            System.out.println("EJERCICIO 8");
            Set<String> ciudadesDistintas = empleados.stream()
                    .map(EmpleadoStream::getCiudad)
                    .collect(Collectors.toSet());
            System.out.println("Ciudades distintas de los empleados: " + ciudadesDistintas);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

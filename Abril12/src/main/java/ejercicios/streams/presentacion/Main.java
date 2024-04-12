package ejercicios.streams.presentacion;

import ejercicios.streams.modelo.Orden;
import ejercicios.streams.persistencia.AccesoOrden;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
public class Main {
    private static void metodo1(List<Orden> list) {
        list.stream()
                .filter(x -> x.getPrecioUnitario() > 30)
                .forEach(System.out::println);
    }
    private static void metodo2(List<Orden> list) {
        list.stream()
                .sorted(Comparator.comparingDouble(Orden::getPrecioUnitario).reversed())
                .forEach(System.out::println);
    }
    private static void metodo3(List<Orden> list) {
        Optional<Orden> fx = list.stream()
                .min(Comparator.comparingDouble(Orden::getPrecioUnitario));
        fx.ifPresent(min -> {
            list.stream()
                    .filter(x -> x.getPrecioUnitario() == min.getPrecioUnitario())
                    .forEach(System.out::println);
        });
    }
    private static void metodo4(List<Orden> list) {
        IntSummaryStatistics stats = list.stream()
                .collect(Collectors.summarizingInt(Orden::getCantidad));
        System.out.println(stats);
    }
    private static void metodo5(List<Orden> list) {
        list.stream()
                .collect(Collectors.groupingBy(Orden::getIdProducto, Collectors.summingInt(Orden::getCantidad)))
                .forEach((productoId, sumaCantidad) -> System.out.println("Producto ID: " + productoId + ", Suma de cantidades: " + sumaCantidad));
    }

    public static void main(String[] args) {
        AccesoOrden ao = new AccesoOrden();
        try{
            System.out.println("========================== EJERCICIO A ==========================");
            metodo1(ao.obtenerOrdenes());
            System.out.println("========================== EJERCICIO B ==========================");
            metodo2(ao.obtenerOrdenes());
            System.out.println("========================== EJERCICIO C ==========================");
            metodo3(ao.obtenerOrdenes());
            System.out.println("========================== EJERCICIO D ==========================");
            metodo4(ao.obtenerOrdenes());
            System.out.println("========================== EJERCICIO E ==========================");
            metodo5(ao.obtenerOrdenes());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

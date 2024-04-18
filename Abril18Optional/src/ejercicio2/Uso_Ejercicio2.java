package ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Uso_Ejercicio2 {
    public static <T> Optional<T> obtenerElemento(List<T> lista, int posicion) {
        if (lista.isEmpty() || posicion < 0 || posicion >= lista.size()) {
            return Optional.empty();
        }
        return Optional.of(lista.get(posicion));
    }

    public static void main(String[] args) {
        List<String> vehiculos = new ArrayList<>();
        vehiculos.add("Avión");
        vehiculos.add("Coche");
        vehiculos.add("Camion");

        int pos = 3;

        Optional<String> vehiculoOpt = obtenerElemento(vehiculos, pos);

        String vehiculoPred = "Moto";

        String elemento = vehiculoOpt.orElse(vehiculoPred);
        System.out.println("Elemento obtenido: " + elemento);
    }
}

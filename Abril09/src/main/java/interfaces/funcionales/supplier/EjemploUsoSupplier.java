package interfaces.funcionales.supplier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class EjemploUsoSupplier {
    // Proveedor de números aleatorios: Generar un número aleatorio en el rango
    //especificado.
    public static void metodo1(int min, int max){
        Supplier<Integer> generadorAleatorio = () -> (int) (Math.random() * (max - min + 1)) + min;
        System.out.println("Numero aleatorio: " + generadorAleatorio.get());
    }

    //Proveedor de una lista predefinida:Devolver una lista predefinida de elementos.
    public static void metodo2(){
        Supplier<List<String>> listaPredefinida = () -> {
            List<String> lista = new ArrayList<>();
            lista.add("elemento1");
            lista.add("elemento2");
            lista.add("elemento3");
            return lista;
        };
        System.out.println(listaPredefinida.get());
    }

    // Proveedor de fecha y hora actual: Obtener la fecha y hora actual del sistema.
    public static void metodo3(){
        Supplier<LocalDateTime> fechaHora = LocalDateTime::now;
        System.out.println(fechaHora.get());
    }

    //Proveedor de un nuevo objeto String vacío: Crear y devolver una cadena de texto
    //vacía.
    public static void metodo4(){
        Supplier<String> vaciarCadena = () -> "";
        System.out.println("Cadena de texto vacia: \""+vaciarCadena.get() + "\"");
    }

    //Proveedor de un objeto de configuración de la aplicación: Devolver un objeto que
    //contiene la configuración de la aplicación, como rutas de archivos, ajustes de
    //conexión, etc.
    public static void metodo5(){

    }
    public static void main(String[] args) {
        metodo1(1,20);
        metodo2();
        metodo3();
        metodo4();
    }
}

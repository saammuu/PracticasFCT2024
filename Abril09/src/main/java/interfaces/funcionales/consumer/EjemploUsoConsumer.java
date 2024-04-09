package interfaces.funcionales.consumer;

import modelo.Producto;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;

public class EjemploUsoConsumer {
    //Consumidor para imprimir en mayúsculas: Tomar una cadena de texto y mostrarla
    //en mayúsculas.
    private static void metodo1(){
        Consumer<String> imprimeMayus = cadena -> System.out.println(cadena.toUpperCase());
        imprimeMayus.accept("hola mundo");
    }

    //Consumidor para imprimir números y sus cuadrados: Tomar un número entero y
    //mostrarlo junto con su cuadrado.
    private static void metodo2(){
        Consumer<Double> cuadradoNum = x -> System.out.println(x+ ", "+ Math.pow(x,2));
        cuadradoNum.accept(3.0);
    }

    //Consumidor para imprimir detalles de un producto: Tomar un objeto Producto y
    //mostrar sus detalles como nombre, precio, etc.
    private static void metodo3(){
        Consumer<Producto> detallesProducto = System.out::println;
        detallesProducto.accept(new Producto());
    }

    //Consumidor para mostrar un mensaje en un cuadro de diálogo: Tomar un mensaje
    //de texto y mostrarlo en un cuadro de diálogo en la interfaz de usuario.
    private static void metodo4(){
        Consumer<String> mostrarDialog = cadena -> {
            JOptionPane.showMessageDialog(null,cadena);
        };
        mostrarDialog.accept("Hola Dialogo");
    }

    //Consumidor para escribir en un archivo de registro: Tomar un registro de eventos y
    //escribirlo en un archivo de registro para su seguimiento.
    private static void metodo5(){
        Consumer<String> registrarEvent = cadena -> {
            File archivo = new File("./archivo.txt");
            try {
                FileWriter fw = new FileWriter(archivo, true);
                fw.write(cadena +"\n");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        registrarEvent.accept("Linea 1 djifjds");
        registrarEvent.accept("Linea 2 djifjds");
        registrarEvent.accept("Linea 3 djifjds");

    }


    public static void main(String[] args) {
        metodo1();
        metodo2();
        metodo3();
        metodo4();
        metodo5();
    }
}

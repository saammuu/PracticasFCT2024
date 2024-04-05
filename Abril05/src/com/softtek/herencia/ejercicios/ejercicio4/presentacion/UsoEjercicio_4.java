package com.softtek.herencia.ejercicios.ejercicio4.presentacion;

import com.softtek.herencia.ejercicios.ejercicio3.modelo.Figura;
import com.softtek.herencia.ejercicios.ejercicio4.modelo.Bateria;
import com.softtek.herencia.ejercicios.ejercicio4.modelo.Flauta;
import com.softtek.herencia.ejercicios.ejercicio4.modelo.Guitarra;
import com.softtek.herencia.ejercicios.ejercicio4.modelo.InstrumentoMusical;

public class UsoEjercicio_4 {
    public static void main(String[] args) {
        Guitarra guido = new Guitarra("MGuitarras", "Metal");
        Bateria bataca = new Bateria("MBaterias",6);
        Flauta ham = new Flauta("MFlautas","Madera");

        InstrumentoMusical instrumentos [] = {guido, bataca, ham};
        for (InstrumentoMusical instrumento : instrumentos) {
            System.out.println("Sonido: " + instrumento.emitirSonido());
        }
    }
}

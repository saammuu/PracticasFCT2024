package ejercicios.polimorfismo.presentacion;

import ejercicios.polimorfismo.modelo.Factura;
import ejercicios.polimorfismo.modelo.IvaGeneral;
import ejercicios.polimorfismo.modelo.IvaSuperReducido;
import ejercicios.polimorfismo.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IvaGeneral ig = new IvaGeneral();
        IvaSuperReducido isr = new IvaSuperReducido();
        Producto p1 = new Producto("raton",6.95);
        Producto p2 = new Producto("teclado",11.95);
        List<Producto> productosList = new ArrayList<>();
        productosList.add(p1);
        productosList.add(p2);
        Factura f1 = new Factura(ig,productosList);
        Factura f2 = new Factura(isr,productosList);
        System.out.println(f1.calcularTotalFactura());
        System.out.println(f2.calcularTotalFactura());
    }
}

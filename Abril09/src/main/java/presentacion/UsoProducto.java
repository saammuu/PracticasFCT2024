package presentacion;

import modelo.Producto;

public class UsoProducto {
    public static void main(String[] args) {
        System.out.println(Producto.CONTADOR);
        Producto p1 = new Producto();
        System.out.println(p1.toString());
        Producto p2 = new Producto();
        System.out.println(p2);
    }
}

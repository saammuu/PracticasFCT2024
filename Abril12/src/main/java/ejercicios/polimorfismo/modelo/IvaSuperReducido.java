package ejercicios.polimorfismo.modelo;

public class IvaSuperReducido implements Impuesto{
    @Override
    public double calcularImpuesto(Producto p) {
        return p.getPrecio()*1.04;
    }
}

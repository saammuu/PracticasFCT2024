package ejercicios.polimorfismo.modelo;

public class IvaGeneral implements  Impuesto{
    @Override
    public double calcularImpuesto(Producto p) {
        return p.getPrecio()*1.21;
    }
}
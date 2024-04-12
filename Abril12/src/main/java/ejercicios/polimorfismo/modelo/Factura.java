package ejercicios.polimorfismo.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    private Impuesto impuesto;
    private List<Producto> productos;

    public double calcularTotalFactura(){
        double total=0;
        for (int i = 0; i < productos.size(); i++) {
            total+= impuesto.calcularImpuesto(productos.get(i));
        }
        return total;
    };
}

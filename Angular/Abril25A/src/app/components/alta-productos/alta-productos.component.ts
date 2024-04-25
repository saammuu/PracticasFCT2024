import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ProductoService } from '../../services/producto.service';
import { Producto } from '../../models/producto';

@Component({
  selector: 'app-alta-productos',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './alta-productos.component.html',
  styleUrl: './alta-productos.component.css'
})
export class AltaProductosComponent {

  constructor(private servicio : ProductoService){}
  producto : Producto |undefined;

  idProductoSelected:number = 0;
  nombreProductoSelected: string = '';
  precioUnitarioSelected:number = 0;
  discontinuadoSelected:number = 0;

  insertarProducto(): void {
    const nuevoProducto: Producto = {
      idProducto: this.idProductoSelected,
      nombreProducto: this.nombreProductoSelected,
      precioUnitario: this.precioUnitarioSelected,
      discontinuado: this.discontinuadoSelected
    };

    this.servicio.insertarProducto(nuevoProducto).subscribe(() => {
      this.actualizarLista();
    });
  }

  actualizarLista(): void {
    this.servicio.obtenerProductos().subscribe(
      datos => {
        this.servicio.productoCambio.next(datos); 
      },
      error => {
        console.error('Error al actualizar la lista de productos:', error);
      }
    );
  }
}

import { Component, Input } from '@angular/core';
import { ProductoService } from '../../services/producto.service';

@Component({
  selector: 'app-eliminar-producto',
  standalone: true,
  imports: [],
  templateUrl: './eliminar-producto.component.html',
  styleUrl: './eliminar-producto.component.css'
})
export class EliminarProductoComponent {
  @Input() productoId: number | undefined;

  constructor(private productoService: ProductoService) {}

  eliminarProducto(): void {
    if (this.productoId !== undefined) {
      this.productoService.eliminarProducto(this.productoId).subscribe(() => {
        console.log('Producto eliminado');
        // TODO: Actualizar la lista
        this.actualizarLista();
      });
    }
  }

  actualizarLista(): void {
    this.productoService.obtenerProductos().subscribe(
      datos => {
        this.productoService.productoCambio.next(datos); 
      },
      error => {
        console.error('Error al actualizar la lista de productos:', error);
      }
    );
  }
}

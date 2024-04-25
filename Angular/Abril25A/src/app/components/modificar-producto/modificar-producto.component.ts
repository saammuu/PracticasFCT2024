import { Component } from '@angular/core';
import { Producto } from '../../models/producto';
import { ProductoService } from '../../services/producto.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-modificar-producto',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './modificar-producto.component.html',
  styleUrl: './modificar-producto.component.css'
})
export class ModificarProductoComponent {
  idProducto: number | undefined;
  nombreProducto: string | undefined;
  precioProducto: number | undefined;
  discontinuado: number | undefined;

  constructor(private productoService: ProductoService) {}

  modificarProducto(): void {
    if (this.idProducto !== undefined && this.nombreProducto !== undefined && this.precioProducto !== undefined && this.discontinuado !== undefined) {
      const producto: Producto = {
        idProducto: this.idProducto,
        nombreProducto: this.nombreProducto,
        precioUnitario: this.precioProducto,
        discontinuado: this.discontinuado
      };

      this.productoService.modificarProducto(producto).subscribe(() => {
        console.log('Producto modificado correctamente');
      });
    } else {
      console.error('Todos los campos son obligatorios');
    }
  }
}
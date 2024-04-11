import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-reto2',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './reto2.component.html',
  styleUrl: './reto2.component.css'
})
export class Reto2Component {
  mensaje: string = '';

  ingresarProducto() {
    const descripcion = (<HTMLInputElement>document.getElementById('descripcion')).value;
    const codigo = parseInt((<HTMLInputElement>document.getElementById('codigo')).value);
    const costo = parseInt((<HTMLInputElement>document.getElementById('costo')).value);
    const venta = parseInt((<HTMLInputElement>document.getElementById('venta')).value);
    const stock = parseInt((<HTMLInputElement>document.getElementById('stock')).value);

    if (costo > 0 && venta > 0 && stock > 0) {
      this.mensaje = 'Producto dado de alta';
    } else {
      this.mensaje = 'No se ha dado de alta';
    }
  }
}

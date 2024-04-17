import { Component } from '@angular/core';
import { Ej2HijoComponent } from '../ej2-hijo/ej2-hijo.component';

@Component({
  selector: 'app-ej2-padre',
  standalone: true,
  imports: [Ej2HijoComponent],
  templateUrl: './ej2-padre.component.html',
  styleUrl: './ej2-padre.component.css'
})
export class Ej2PadreComponent {
  cesta: string[];
  
  constructor() {
    this.cesta = [];
  }

  anyadirProductos(producto: string){
    this.cesta.push(producto);
  }
}

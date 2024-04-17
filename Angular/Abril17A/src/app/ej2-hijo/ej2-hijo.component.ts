import { Component, Output, EventEmitter } from '@angular/core';
import { Ej2PadreComponent } from '../ej2-padre/ej2-padre.component';

@Component({
  selector: 'app-ej2-hijo',
  standalone: true,
  imports: [Ej2PadreComponent],
  templateUrl: './ej2-hijo.component.html',
  styleUrl: './ej2-hijo.component.css'
})
export class Ej2HijoComponent {
  @Output()
  emitter: EventEmitter<string> = new EventEmitter();
  listaProductos: string[] = ['leche', 'pan', 'café', 'azúcar', 'huevos', 'plátanos'];

  addProductosACesta(producto: string){
    this.emitter.emit(producto);
  }
}

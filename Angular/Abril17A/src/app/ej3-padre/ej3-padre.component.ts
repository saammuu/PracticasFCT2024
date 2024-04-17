import { Component, EventEmitter, Output } from '@angular/core';
import { Ej3HijoComponent } from '../ej3-hijo/ej3-hijo.component';

@Component({
  selector: 'app-ej3-padre',
  standalone: true,
  imports: [Ej3HijoComponent],
  templateUrl: './ej3-padre.component.html',
  styleUrl: './ej3-padre.component.css'
})
export class Ej3PadreComponent {
  contenedorAsignaturas: string[] = [];

  anyadirAsignatura(asignatura: string){
    this.contenedorAsignaturas.push(asignatura);
  }

}

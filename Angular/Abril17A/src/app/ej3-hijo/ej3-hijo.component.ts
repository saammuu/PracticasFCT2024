import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ej3-hijo',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './ej3-hijo.component.html',
  styleUrl: './ej3-hijo.component.css'
})
export class Ej3HijoComponent {
  @Output()
  emitter: EventEmitter<string> = new EventEmitter();
  asignaturaSelected = '';
  listaAsignaturas: string[] = [
    'Lengua', 'Matematicas', 'Historia', 'Ingles'
  ];

  enviarAsignatura(value: string){
    this.emitter.emit(this.asignaturaSelected)
  }
}

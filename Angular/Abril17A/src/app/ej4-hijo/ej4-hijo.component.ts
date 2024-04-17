import { Component, EventEmitter, Output } from '@angular/core';
import { Person } from '../model/person';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ej4-hijo',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './ej4-hijo.component.html',
  styleUrl: './ej4-hijo.component.css'
})
export class Ej4HijoComponent {
  nombre : string = '';
  edad : number = 0;

  @Output()
  emitter = new EventEmitter<Person>();

  sendPerson(){
    let persona: Person = {
      nombre : this.nombre,
      edad : this.edad
    };
    this.emitter.emit(persona);
  }
}

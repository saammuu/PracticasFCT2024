import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-hijo-comentario',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './hijo-comentario.component.html',
  styleUrl: './hijo-comentario.component.css'
})
export class HijoComentarioComponent {
  @Output()
  emitter: EventEmitter<string> = new EventEmitter;

  comment:string = '';

  enviarComentario(comentario:string){
    this.emitter.emit(comentario);
  }

}

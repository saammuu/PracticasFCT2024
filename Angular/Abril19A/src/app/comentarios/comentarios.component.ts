import { Component } from '@angular/core';
import { HijoComentarioComponent } from '../hijo-comentario/hijo-comentario.component';

@Component({
  selector: 'app-comentarios',
  standalone: true,
  imports: [HijoComentarioComponent],
  templateUrl: './comentarios.component.html',
  styleUrl: './comentarios.component.css'
})
export class ComentariosComponent {
  comentarios: string[] = [];

  addComments(comentario: string){
    this.comentarios.push(comentario);
  }
}

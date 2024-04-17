import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-ej1-hijo',
  standalone: true,
  imports: [],
  templateUrl: './ej1-hijo.component.html',
  styleUrl: './ej1-hijo.component.css'
})
export class Ej1HijoComponent {
  @Input()
  mensajeRecibido: string = '';
}

import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Ej1PadreComponent } from './ej1-padre/ej1-padre.component';
import { Ej2PadreComponent } from './ej2-padre/ej2-padre.component';
import { Ej3PadreComponent } from './ej3-padre/ej3-padre.component';
import { Ej4PadreComponent } from './ej4-padre/ej4-padre.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, Ej1PadreComponent, Ej2PadreComponent, Ej3PadreComponent, Ej4PadreComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Abril17A';
}

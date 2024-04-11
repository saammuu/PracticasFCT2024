import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Ts01Component } from './ts01/ts01.component';
import { Angular01Component } from './angular01/angular01.component';
import { Reto1Component } from './reto1/reto1.component';
import { Reto2Component } from './reto2/reto2.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, Ts01Component, Angular01Component, Reto1Component,Reto2Component],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'fundamentos01';
}

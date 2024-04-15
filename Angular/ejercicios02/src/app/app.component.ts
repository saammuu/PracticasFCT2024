import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ComprobacionInterfacesComponent } from './comprobacion-interfaces/comprobacion-interfaces.component';
import { Directivas01Component } from './directivas01/directivas01.component';
import { Directivas03Component } from './directivas03/directivas03.component';
import { Directivas02Component } from './directivas02/directivas02.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ComprobacionInterfacesComponent, Directivas01Component,Directivas02Component, Directivas03Component],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ejercicios02';
}

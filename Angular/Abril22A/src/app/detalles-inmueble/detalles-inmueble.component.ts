import { Component, Input, OnInit } from '@angular/core';
import { Inmueble } from '../model/inmueble';
import { InmuebleService } from '../services/inmueble.service';

@Component({
  selector: 'app-detalles-inmueble',
  standalone: true,
  imports: [],
  templateUrl: './detalles-inmueble.component.html',
  styleUrl: './detalles-inmueble.component.css'
})
export class DetallesInmuebleComponent implements OnInit{

  inmueble:Inmueble | undefined;

  constructor(private inmuebleServicio: InmuebleService){}
  
  @Input()
  id:string = '';

  ngOnInit(): void {
    this.inmueble = this.inmuebleServicio.obtenerUno(this.id);
  }


}

import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Inmueble } from '../model/inmueble';
import { InmuebleService } from '../services/inmueble.service';

@Component({
  selector: 'app-inmuebles',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './inmuebles.component.html',
  styleUrl: './inmuebles.component.css'
})
export class InmueblesComponent implements OnInit{
  inmuebles:Inmueble[] = [];

  constructor(private inmuebleServicio: InmuebleService){}

  ngOnInit(): void {
    this.inmuebles = this.inmuebleServicio.obtenerTodos();
  }

}

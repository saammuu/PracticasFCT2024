import { Component } from '@angular/core';
import { Ej4HijoComponent } from '../ej4-hijo/ej4-hijo.component';
import { Person } from '../model/person';

@Component({
  selector: 'app-ej4-padre',
  standalone: true,
  imports: [Ej4HijoComponent],
  templateUrl: './ej4-padre.component.html',
  styleUrl: './ej4-padre.component.css'
})
export class Ej4PadreComponent {
  contenedorPersonas : Person[] = [];

  validarPersona(persona : Person){
    console.log(`Producto recibido con nombre: ${persona.nombre}` )
    if(!this.contenedorPersonas.includes(persona)) this.contenedorPersonas.push(persona);
    else alert(`La persona ${persona.nombre} ya está en la lista`)
  }

  deleteUltimaPersona(){this.contenedorPersonas.pop()}

  //Filtro de edad mayor que 18
  mayorDeEdad(){
    let arregloFiltrado : Person[] = this.contenedorPersonas.filter(p => p.edad > 18);
    this.contenedorPersonas = arregloFiltrado;
  }

  dobleEdad(){
    let arregloFiltrado : Person[] = this.contenedorPersonas.map(p => {
      return{
        nombre: p.nombre,
        edad: p.edad*2
      }
    });
    this.contenedorPersonas = arregloFiltrado;
  }
}

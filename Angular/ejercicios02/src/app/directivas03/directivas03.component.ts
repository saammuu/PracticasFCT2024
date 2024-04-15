import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-directivas03',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './directivas03.component.html',
  styleUrl: './directivas03.component.css'
})
export class Directivas03Component {
  cadena:string  = '';
  generoSelected = '';
  nacionalidadSelected = '';
  generos = [
    { id: '1', value: 'hombre', label: 'Hombre' },
    { id: '2', value: 'mujer', label: 'Mujer' },
    { id: '3', value: 'otros', label: 'Otros' }
  ];
  nacionalidades= [
    { id: '1', value: 'española', label: 'Española' },
    { id: '2',value: 'francesa', label: 'Francesa' },
    { id: '3',value: 'italina', label: 'Italiana'}
  ];

  lenguajesProgramacion = [
    {id: false, nombre: "C++"},
    {id:false, nombre:"Java"},
    {id:false, nombre:"JS"},
    {id:false, nombre:"Python"}
  ];
  lenguajeSeleccionado:string = "";

  mostrarInformacion(): void {
    console.log(`Genero: ${this.generoSelected}`)
    console.log(`Nacionalidad: ${this.nacionalidadSelected}`)
    for(let i = 0; i <this.lenguajesProgramacion.length; i++){
 
      if(this.lenguajesProgramacion[i].id == true){

        //console.log(this.lenguajesProgramacion[i].nombre)
        this.cadena+=this.lenguajesProgramacion[i].nombre;
        this.cadena += '  ';
      }
    }
    console.log(`Lenguajes: ${this.cadena}`)
    this.cadena = '';
  }
}

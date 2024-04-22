import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-articulo',
  standalone: true,
  imports: [],
  templateUrl: './articulo.component.html',
  styleUrl: './articulo.component.css'
})
export class ArticuloComponent implements OnInit{
  articulos = [
    {ida: '1', nombre: 'Hacking etico', descripcion: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam non ultrices nisi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae nibh tincidunt, cursus lacus ac, eleifend ipsum.'},
    {ida: '2', nombre: 'Legislación de Seguridad en Europa', descripcion: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam non ultrices nisi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae nibh tincidunt, cursus lacus ac, eleifend ipsum.'},
    {ida: '3', nombre: '¿Cómo evitar que te hackeen la cuenta?', descripcion:'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam non ultrices nisi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae nibh tincidunt, cursus lacus ac, eleifend ipsum.'},
    {ida: '4', nombre: '¿Que es phising?', descripcion: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam non ultrices nisi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae nibh tincidunt, cursus lacus ac, eleifend ipsum.'}
  ];
  ngOnInit(): void {
    console.log(`id recibido: ${this.id}`)
  }

  @Input()
  id:string = '';
}

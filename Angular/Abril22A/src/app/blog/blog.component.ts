import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-blog',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './blog.component.html',
  styleUrl: './blog.component.css'
})
export class BlogComponent {
  articulos = [
    {id: '1', nombre: 'Hacking etico', descripcion: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam non ultrices nisi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae nibh tincidunt, cursus lacus ac, eleifend ipsum.'},
    {id: '2', nombre: 'Legislación de Seguridad en Europa', descripcion: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam non ultrices nisi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae nibh tincidunt, cursus lacus ac, eleifend ipsum.'},
    {id: '3', nombre: '¿Cómo evitar que te hackeen la cuenta?', descripcion:'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam non ultrices nisi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae nibh tincidunt, cursus lacus ac, eleifend ipsum.'},
    {id: '4', nombre: '¿Que es phising?', descripcion: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam non ultrices nisi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae nibh tincidunt, cursus lacus ac, eleifend ipsum.'}
  ];
}

import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Articulo } from '../model/articulo';
import { BlogService } from '../services/blog.service';

@Component({
  selector: 'app-blog',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './blog.component.html',
  styleUrl: './blog.component.css'
})
export class BlogComponent implements OnInit{
articulos: Articulo[] = [];

constructor(private blogService: BlogService ){}

ngOnInit(): void {
  this.articulos = this.blogService.obtenerTodos();
}
}

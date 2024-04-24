import { Component, Input, OnInit } from '@angular/core';
import { Articulo } from '../model/articulo';
import { BlogService } from '../services/blog.service';

@Component({
  selector: 'app-articulo',
  standalone: true,
  imports: [],
  templateUrl: './articulo.component.html',
  styleUrl: './articulo.component.css'
})
export class ArticuloComponent implements OnInit{
  articulo: Articulo |undefined;


  constructor(private blogService : BlogService){}
  @Input()
  id:string = '';
  ngOnInit(): void {
    this.articulo=this.blogService.obtenerUno(this.id);
  }


}

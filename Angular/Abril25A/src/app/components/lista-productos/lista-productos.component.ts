import { Component, OnInit } from '@angular/core';
import { ProductoService } from '../../services/producto.service';
import { Producto } from '../../models/producto';
import { RouterLink, RouterOutlet } from '@angular/router';
import { EliminarProductoComponent } from '../eliminar-producto/eliminar-producto.component';

@Component({
  selector: 'app-lista-productos',
  standalone: true,
  imports: [RouterOutlet,RouterLink, EliminarProductoComponent],
  templateUrl: './lista-productos.component.html',
  styleUrl: './lista-productos.component.css'
})
export class ListaProductosComponent {
  constructor(private servicio : ProductoService){}
  productos : Producto[] = [];


  
  ngOnInit(): void {
    this.servicio.productoCambio.subscribe(
      (data) => {this.productos = data}
    )

    this.servicio.obtenerProductos()
    .subscribe(
      datos =>{
        this.productos = datos;
        console.log("Entra");
      }
    );

  }

}

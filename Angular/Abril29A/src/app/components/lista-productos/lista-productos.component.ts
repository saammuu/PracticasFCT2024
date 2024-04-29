import { Component, OnInit } from '@angular/core';
import { AltaProductoComponent } from '../alta-producto/alta-producto.component';
import { RouterModule } from '@angular/router';
import { ProductoService } from '../../services/producto.service';
import { Producto } from '../../models/producto';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-lista-productos',
  standalone: true,
  imports: [AltaProductoComponent, RouterModule],
  templateUrl: './lista-productos.component.html',
  styleUrl: './lista-productos.component.css'
})
export class ListaProductosComponent implements OnInit{
  constructor(private servicio: ProductoService){}
  productos:Producto[] = [];

  ngOnInit(): void {
    this.servicio.productoCambio
      .subscribe( data => {this.productos = data} );
    
      this.servicio.listar()
      .subscribe(
        datos => {
          this.productos = datos;
          console.log("Entra")
        }
      );
  }

  eliminar(id:number){
    this.servicio.eliminar(id)
    .subscribe(
      () => {
        this.servicio.listar()
        .subscribe( data => this.servicio.productoCambio.next(data) );
      }
    );
  }

  recibirAviso(listaActualizada: Observable<Producto[]>){
    console.warn("REGRESA AL PADRE");
    //listaActualizada.subscribe(data => this.empleados = data);
    this.servicio.listar()
    .subscribe(
      datos => {
        this.productos = datos;
        console.log("Entra en el aviso");
    });
  }
}

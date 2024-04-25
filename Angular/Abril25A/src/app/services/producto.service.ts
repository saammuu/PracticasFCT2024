  import { Injectable } from '@angular/core';
  import { entorno } from '../entorno/entorno';
  import { Observable, Subject } from 'rxjs';
  import { Producto } from '../models/producto';
  import { HttpClient } from '@angular/common/http';

  @Injectable({
    providedIn: 'root'
  })
  export class ProductoService {
    constructor(private http: HttpClient) { }

    private url:string = `${entorno.HOST}/productos`;

    productoCambio = new Subject<Producto[]>();

    obtenerProductos(): Observable<Producto[]>{
      return this.http.get<Producto[]>(this.url);
    }

    insertarProducto(p : Producto){
      return this.http.post(this.url,p);
    }

    eliminarProducto(id:number){
      return this.http.delete(`${this.url}/${id}`);
    }

  }

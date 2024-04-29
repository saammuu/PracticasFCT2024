import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { entorno } from '../entorno/entorno';
import { Observable, Subject, map } from 'rxjs';
import { Producto } from '../models/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  constructor(private http: HttpClient) { }

  private url: string = `${entorno.HOST}/productos`

  productoCambio = new Subject<Producto[]>();

  listar(): Observable<Producto[]>{
    return this.http.get<Producto[]>(this.url)
    .pipe(
      map( data => {
        return data.sort( (a,b) => a.idProducto - b.idProducto );
      })
    );
  }

  listarPorId(id: number){
    return this.http.get<Producto>(`${this.url}/${id}`)
  }

  alta(p:Producto){
    console.log('Entrando en el ALTA');
    return this.http.post(this.url, p);
  }

  modificar(p:Producto){
    console.log("Entrando en MODIFICAR")
    return this.http.put(this.url,p);
  }

  eliminar(id:number){
    return this.http.delete(`${this.url}/${id}`);
  }
}

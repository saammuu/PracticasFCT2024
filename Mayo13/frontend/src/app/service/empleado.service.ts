import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { entorno } from '../environment/entorno';
import { Observable, Subject, map, switchMap } from 'rxjs';
import { Empleado } from '../model/empleado';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

  constructor(private http : HttpClient) { }

  private url: string = `${entorno.HOST}/empleados`;

  empleadoCambio = new Subject<Empleado[]>();

  listar(): Observable<Empleado[]>{
    return this.http.get<Empleado[]>(this.url)
    .pipe(
      map(data => {
        return data.sort( (a,b) => a.idEmpleado - b.idEmpleado )
      })
    );
  }

  // USO DEL OPERADOR SWITCHMAP
  alta(e:Empleado){
    console.log("Entrando en el metodo alta del servicio");
    return this.http.post(this.url, e)
    .pipe(
      switchMap( () => {
        return this.http.get<Empleado[]>(this.url)
        .pipe(
          map(data => {
            return data.sort( (a,b) => a.idEmpleado - b.idEmpleado )
          })
        );
      })
    );
  }

  listarPorId(id: number){
    return this.http.get<Empleado>(`${this.url}/${id}`)
  }

  modificar(e: Empleado): Observable<Empleado[]> {
    console.log("Entrando en el método modificar del servicio");
    return this.http.put(`${this.url}`, e)
      .pipe(
        switchMap(() => {
          return this.http.get<Empleado[]>(this.url)
            .pipe(
              map(data => {
                return data.sort((a, b) => a.idEmpleado - b.idEmpleado);
              })
            );
        })
      );
  }

  eliminar(id: number): Observable<void> {
    console.log("Entrando en el método eliminar del servicio");
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}

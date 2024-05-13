import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { EmpleadoService } from '../../service/empleado.service';
import { Empleado } from '../../model/empleado';
import { AltaEmpleadoComponent } from '../alta-empleado/alta-empleado.component';
import { ModificaEmpleadoComponent } from '../modifica-empleado/modifica-empleado.component';

@Component({
  selector: 'app-lista-empleados',
  standalone: true,
  imports: [AltaEmpleadoComponent,ModificaEmpleadoComponent ,RouterModule],
  templateUrl: './lista-empleados.component.html',
  styleUrl: './lista-empleados.component.css'
})
export class ListaEmpleadosComponent implements OnInit{
  
  constructor(private servicio : EmpleadoService){}

  empleados: Empleado[] = [];

  ngOnInit(): void {
    this.servicio.empleadoCambio
    .subscribe( data => {this.empleados = data} )
    console.log("Actualización recibida del servicio");

    this.servicio.listar()
    .subscribe(
      datos => {
        this.empleados = datos;
        console.log("Entramos al listar del componente")
      }
    );
  }

  eliminarEmpleado(id: number): void {
    this.servicio.eliminar(id).subscribe(
      () => {
        console.log("Empleado eliminado correctamente");
        this.servicio.listar().subscribe(
          datos => {
            this.empleados = datos;
          }
        );
      }
    );
  }
}

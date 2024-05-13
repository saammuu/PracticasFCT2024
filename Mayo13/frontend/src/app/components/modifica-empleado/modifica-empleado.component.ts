import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { EmpleadoService } from '../../service/empleado.service';
import { Empleado } from '../../model/empleado';

@Component({
  selector: 'app-modifica-empleado',
  standalone: true,
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './modifica-empleado.component.html',
  styleUrl: './modifica-empleado.component.css'
})
export class ModificaEmpleadoComponent implements OnInit {
  form: FormGroup;
  id: number = 0;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private servicio: EmpleadoService
  ) {
    this.form = new FormGroup({
      'idEmpleado': new FormControl(0),
      'nombreEmpleado': new FormControl('', Validators.required),
      'sueldoEmpleado': new FormControl(0, Validators.required),
      'correoEmpleado': new FormControl('', [Validators.required, Validators.pattern(/^[^\s@]+@[^\s@]+\.[^\s@]+$/)])
    });
  }

  ngOnInit(): void {
    this.route.params.subscribe(
      data => {
        this.id = data['id'];
        this.formaFormulario();
      }
    );
  }

  formaFormulario() {
    if (this.id !== 0) {
      this.servicio.listarPorId(this.id).subscribe(
        data => {
          this.form.patchValue(data);
        }
      );
    }
  }

  modificar(){
    if (this.form.valid) {
      const empleado: Empleado = this.form.value;
      if (empleado.idEmpleado) {
        this.servicio.modificar(empleado).subscribe(
          () => {
            console.log("Empleado actualizado correctamente");
            this.servicio.listar()
            .subscribe(data => {
              this.servicio.empleadoCambio.next(data);
            })
            this.router.navigate(['']);
          }
        );
      }
    }
  }
}

import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { EmpleadoService } from '../../service/empleado.service';
import { Empleado } from '../../model/empleado';

@Component({
  selector: 'app-alta-empleado',
  standalone: true,
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './alta-empleado.component.html',
  styleUrl: './alta-empleado.component.css'
})
export class AltaEmpleadoComponent implements OnInit {
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

  insertar() {
    if (this.form.valid) {
      const nuevoEmpleado: Empleado = this.form.value;
      this.servicio.alta(nuevoEmpleado).subscribe(
        () => {
          console.log("Empleado insertado correctamente");
          this.servicio.listar()
          .subscribe(data => {
            this.servicio.empleadoCambio.next(data);
          })
          this.router.navigate(['']);
        }
      );
    } else {
      console.log("Formulario inválido, no se puede insertar el empleado");
    }
  }

}

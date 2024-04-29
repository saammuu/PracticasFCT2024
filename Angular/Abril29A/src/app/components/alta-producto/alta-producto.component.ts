import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { ProductoService } from '../../services/producto.service';
import { Producto } from '../../models/producto';

@Component({
  selector: 'app-alta-producto',
  standalone: true,
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './alta-producto.component.html',
  styleUrl: './alta-producto.component.css'
})
export class AltaProductoComponent implements OnInit{
  form: FormGroup;
  id:number = 0;
  edicion: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private servicio: ProductoService
  ){
    this.form = new FormGroup({
      'idProducto' : new FormControl(0),
      'nombre' : new FormControl(''),
      'precio' : new FormControl(0),
      'discontinuado': new FormControl(0)
    });
  }

  ngOnInit(): void {
    this.route.params
      .subscribe(
        data => {
          this.id = data['id'];
          this.edicion = data['id'] != null;
          this.formaFormulario();
        }
      );
  }

  formaFormulario(){
    if(this.edicion){
      this.servicio.listarPorId(this.id)
      .subscribe(
        data => {
          this.form = new FormGroup({
            'idProducto' : new FormControl(data.idProducto),
            'nombre' : new FormControl(data.nombreProducto),
            'precio' : new FormControl(data.precioUnitario),
            'discontinuado': new FormControl(data.discontinuado)
          })
        }
      );
    }
  }

  operar(){
    let p : Producto = {
      'idProducto' : this.form.value['idProducto'],
      'nombreProducto' : this.form.value['nombre'],
      'precioUnitario' : this.form.value['precio'],
      'discontinuado': this.form.value['discontinuado']
    }

    if(this.edicion){
      this.servicio.modificar(p)
      .subscribe( () => {
        this.servicio.listar()
        .subscribe( data => {
          this.servicio.productoCambio.next(data)
        });
      });
    } else{
      this.servicio.alta(p)
      .subscribe( () => {
        this.servicio.listar()
        .subscribe( data => {
          this.servicio.productoCambio.next(data)
        });
      });
    }

    this.router.navigate(['']);
  }
}

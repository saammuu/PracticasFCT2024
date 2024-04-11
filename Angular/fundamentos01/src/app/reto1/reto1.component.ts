import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-reto1',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './reto1.component.html',
  styleUrl: './reto1.component.css'
})
export class Reto1Component {
  email: string = '';
  password : string = '';
  password2 : string = '';
  bienvenida : string = 'BIENVENIDO';
  error: string = 'Las contraseñas no coinciden'

  mensaje : string = '';
  
  validarPassword() {
    this.mensaje = this.password === this.password2 ? this.bienvenida : this.error;
  }
}

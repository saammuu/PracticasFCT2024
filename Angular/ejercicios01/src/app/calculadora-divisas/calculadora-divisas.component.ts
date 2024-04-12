import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TiposCambio } from '../modelo/tiposCambio';

@Component({
  selector: 'app-calculadora-divisas',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './calculadora-divisas.component.html',
  styleUrl: './calculadora-divisas.component.css'
})
export class CalculadoraDivisasComponent {
  cantidad: number = 0;
  monedaOrigen: string = 'Euro';
  monedaDestino: string = 'Dólares';
  tiposCambio : TiposCambio = {
    'Euro': { 'Dólares': 1.18, 'Libras': 0.86 },
    'Dólares': { 'Euro': 0.85, 'Libras': 0.72 },
    'Libras': { 'Euro': 1.17, 'Dólares': 1.39 }
  };
  resultado: number = 0;

  convertir() {
    this.resultado = this.cantidad * this.tiposCambio[this.monedaOrigen][this.monedaDestino];
  }
}

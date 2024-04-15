import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-directivas01',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './directivas01.component.html',
  styleUrl: './directivas01.component.css'
})
export class Directivas01Component {
  ramSelected = '';
  discoSelected = '';
  tarjetaSelected = false;
  procesadorSelected = '';
  alimentacionSelected = '';
  tiposRam = [
    { id: '1', value: '32', label: 'RAM32' },
    { id: '2', value: '16', label: 'RAM16' },
    { id: '3', value: '8', label: 'RAM8' }
  ];

  tiposDiscosDuros = [
    { value: 'HDD', label: 'HDD' },
    { value: 'SSD', label: 'SSD' }
  ];

  fuentesAlimentacion =  [
    { id: '1', value: '600', label: '600' },
    { id: '2', value: '400', label: '400' },
    { id: '3', value: '300', label: '300' }
  ];

  tarjetaGrafica: boolean = true;

  procesador= [
    { id: '1', value: 'i9', label: 'Intel i9' },
    { id: '2',value: 'i7', label: 'Intel i7' },
    { id: '3',value: 'i3', label: 'Intel i3'}
  ];
;

  mostrarInformacion(): void {
    console.log(`Ram elegida: ${this.ramSelected}`)
    console.log(`Tipo de Procesador: ${this.procesadorSelected}`)
    console.log(`Ha seleccionado tarjeta? ${this.tarjetaGrafica}`)
    console.log(`Fuente de alimentacion: ${this.alimentacionSelected}`)
  }
}

import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-directivas02',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './directivas02.component.html',
  styleUrl: './directivas02.component.css'
})
export class Directivas02Component {
  origenSelected = '';
  destinoSelected = '';
  idaSelected = '';
  vueltaSelected = '';
  pasajeros = 0;
  origen = [
    { id: '1', value: 'Madrid', label: 'Madrid' },
    { id: '2', value: 'Barcelona', label: 'Barcelona' },
    { id: '3', value: 'Valencia', label: 'Valencia' },
    { id: '4', value: 'Sevilla', label: 'Sevilla' },
    { id: '5', value: 'Santander', label: 'Santander' }
  ];
  destino = [
    { id: '1', value: 'Madrid', label: 'Madrid' },
    { id: '2', value: 'Barcelona', label: 'Barcelona' },
    { id: '3', value: 'Valencia', label: 'Valencia' },
    { id: '4', value: 'Sevilla', label: 'Sevilla' },
    { id: '5', value: 'Santander', label: 'Santander' }
  ];

  mostrarInformacion(): void {
    alert(`
      Origen: ${this.origenSelected}
      Destino: ${this.destinoSelected}
      Fecha de ida: ${this.idaSelected}
      Fecha de vuelta: ${this.vueltaSelected}
      Pasajeros: ${this.pasajeros}
    `);
  }
}

import { Component } from '@angular/core';
import {Temporada} from '../modelo/temporada';

@Component({
  selector: 'app-tipodatos',
  standalone: true,
  imports: [],
  templateUrl: './tipodatos.component.html',
  styleUrl: './tipodatos.component.css'
})
export class TipodatosComponent {
  ejercicio1() {
    // EJERCICIO 1
    // TODO: Modifique el código para agregar tipos a las declaraciones de variables.
    // El JavaScript resultante debería verse igual que el ejemplo original cuando haya terminado.
    let firstName: string;
    let lastName: string;
    let fullName: string;
    let age: number;
    let ukCitizen: boolean;
  
    firstName = 'Rebecca';
    lastName = 'Smith';
    age = 42;
    ukCitizen = false;
    fullName = firstName + " " + lastName;
  
    if (ukCitizen) {
      console.log("My name is " + fullName + ", I'm " + age + ", and I'm a citizen of the United Kingdom.");
    } else {
      console.log("My name is " + fullName + ", I'm " + age + ", and I'm not a citizen of the United Kingdom.");
    }
  }

  ejercicio2() {
    /* EJERCICIO 2
    TODO: Puede utilizar tipos para garantizar los resultados de la operación.
    Ejecute el código tal cual y luego modifíquelo.
    que tenga variables fuertemente tipadas. Luego, solucione los errores que
    encuentre para que el resultado
    devuelto a a es 12. */
    let x: number;
    let y: number;
    let a: string;
  
    x = 5;
    y = 7;
    a = (x + y).toString();
  
    console.log(a);
  }
  
 
  ejercicio3() {
    // EJERCICIO 3
    function whichMonths(season: Temporada): string {
      let monthsInSeason: string;
      switch (season) {
        case Temporada.Otoño:
          monthsInSeason = "Septiembre a Noviembre";
          break;
        case Temporada.Invierno:
          monthsInSeason = "Diciembre a Febrero";
          break;
        case Temporada.Primavera:
          monthsInSeason = "Marzo a Mayo";
          break;
        case Temporada.Verano:
          monthsInSeason = "Junio a Agosto";
          break;
      }
      return monthsInSeason;
    }

    console.log(whichMonths(Temporada.Otoño));
  }  

  ejercicio4() {
    /* EXERCISE 4
    TODO: Declare the array as the type to match the type of the items in the array. */
    let randomNumbers: number[] = [];
    let nextNumber: number;
    for (let i = 0; i < 10; i++) {
      nextNumber = Math.floor(Math.random() * (100 - 1)) + 1;
      randomNumbers.push(nextNumber);
    }
    console.log(randomNumbers);
  }
  
  
}


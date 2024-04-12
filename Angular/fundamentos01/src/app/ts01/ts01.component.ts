import { Component } from '@angular/core';
import { TipoContrato } from '../modelo/tipo_contrato';


@Component({
  selector: 'app-ts01',
  standalone: true,
  imports: [],
  templateUrl: './ts01.component.html',
  styleUrl: './ts01.component.css',
})
export class Ts01Component {
  variables(): void {
    let x: number; //* Explicitly declares x as a number type
    let y = 1; //* Implicitly declares y as a number type
    let z;
    let flag: boolean;
    let yes = true;
    let no = false;
    let n: number = 123.456;
    let big: bigint = 100n; //* Declares z without initializing it
  }
  otrasVariables(): void {
    let s: string;
    let empty = '';
    let abc = 'abc';
    let firstName: string = 'Mateo';
    let sentence: string = `My name is ${firstName}.
    I am new to TypeScript.`;
    console.log(sentence);
  }
  tipoString(): void {
    let saludo = new String('Hola Mundo');
    let lorem: string =
      '       Lorem ipsum, dolor sit amet consectetur adipisicing elit. Est, et dolorum. Adipisci sequi, voluptates accusamus earum magnam non pariatur odit consequuntur dicta modi. Quam soluta aliquid nam ea quod dolore.      ';

    console.log(saludo, lorem);
    console.log(
      saludo.length,
      lorem.length,
      saludo.toUpperCase(),
      saludo.toLowerCase(),
      lorem.trim(),
      lorem.trim().split(' '),
      lorem.split(',')
    );
    //Interpolción de variables
    //Template String
    let nombre = 'Jorge';
    let apellido = 'López';
    let saludo2 = `Hola mi nombre es ${nombre} ${apellido}.`;
    console.log(saludo2);
  }
  tipoNumber(): void {
    let a = 2;
    let b = new Number(1);
    let c = 7.19;
    let d = '5.6';

    console.log(a, b);
    console.log(c.toFixed(1));
    console.log(c.toFixed(5));
    console.log(parseInt(d));
    console.log(parseFloat(d));
    console.log(typeof c, typeof d);
    console.log(c + parseInt(d));
    console.log(c + parseFloat(d));
    console.log(c + Number.parseInt(d));
    console.log(c + Number.parseFloat(d));
  }

  operadores() {
    /*  Relacionales: >, <,   >=, <=, ==, ===, !=, !== */

    console.log(8 > 9);
    console.log(9 > 8);
    console.log(8 >= 9);
    console.log(9 >= 8);
    console.log(7 < 7);
    console.log(7 <= 7);

    /*
    = 1 igual es asignación  de variable
    == 2 iguales es comparacion de valores
    === 3 igulaes es comparación de tipo de dato y de valor
    */

    console.log(7 == 7);
    console.log(7 === 7);
    /*console.log("7" == 7);
    
    console.log(0 == false);
    console.log("7" === 7);
    console.log(0 === false); */
  }
  usaEnumeracion(): void {
    let tipoCont: TipoContrato = TipoContrato.practicas;
    console.log(tipoCont);
    console.log(TipoContrato[tipoCont]);
  }

  tipoAny(): void {
    let randomValue: any;
    console.log(randomValue);
    randomValue = 'Mateo'; // OK
    randomValue = true;
    console.log(randomValue.name); // Logs "undefined" to the console
    randomValue(); // Returns "randomValue is not a function" error
    randomValue.toUpperCase(); // Returns "randomValue is not a function" error    // OK

  }
  tipoUnknown(): void {
    let randomValue: unknown;
    console.log(randomValue);
    randomValue = true;
    randomValue = 'Mateo';
    // console.log(randomValue.name); // Logs "undefined" to the console
    // randomValue(); // Returns "randomValue is not a function" error
    // randomValue.toUpperCase(); // Returns "randomValue is not a function" error
  }

  asercionTipos(): void {
    let variable: any;
    variable = "Hola mundo";
    console.log(variable.toUpperCase())
    console.log((variable as string).toUpperCase()); //mas recomendada
    console.log((<string>variable).toUpperCase());

  }

  tiposUnion(): void {
    let multiType: number | boolean;
    multiType = 20;         //* Valid
    multiType = true;       //* Valid
    // multiType = "twenty";   //* Invalid

  }

  tiposLiterales(): void {
    type dice = 1 | 2 | 3 | 4 | 5 | 6;
    let diceRoll: dice;
    diceRoll = 1;    //* Valid
    diceRoll = 2;    //* Valid
    // diceRoll = 7;    //* Invalid
  }

  matrices(): void {
    let list1: number[] = [1,2,3];
    let list2: Array<number> = [1,2,3];
  }
}
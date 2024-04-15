import { Component } from '@angular/core';
import { Loan } from '../model/loan';
import { ConventionalLoan } from '../model/conventionalLoan';

function calculateConventionalLoanPayment(loanTerms: ConventionalLoan): string {
  let interest = loanTerms.interestRate / 1200;
  let payment;
  payment = loanTerms.principal * interest / (1 - (Math.pow(1 / (1 + interest), loanTerms.months)));
  return 'The conventional loan payment is ' + payment.toFixed(2);
}
function calculateInterestOnlyLoanPayment(loanTerms: Loan): string {
  let interest = loanTerms.interestRate / 1200; 
  let payment;
  payment = loanTerms.principal * interest;
  return 'The interest only loan payment is ' + payment.toFixed(2);
}

@Component({
  selector: 'app-comprobacion-interfaces',
  standalone: true,
  imports: [],
  templateUrl: './comprobacion-interfaces.component.html',
  styleUrl: './comprobacion-interfaces.component.css'
})
export class ComprobacionInterfacesComponent {
  pruebaejercicios(): void {
    let interestOnlyPayment = calculateInterestOnlyLoanPayment({ principal: 30000, interestRate: 5 });
    let conventionalPayment = calculateConventionalLoanPayment({ principal: 30000, interestRate: 5, months: 180 });

    console.log(interestOnlyPayment);
    console.log(conventionalPayment); 
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { SignInRequest } from '../model/signin_request';
import { JwtAuthenticationResponse } from '../model/JwtAuthenticationResponse';
import { entorno } from '../environment/entorno';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient, private router: Router) { }

  autenticar(datos: SignInRequest){
    return this.http.post<JwtAuthenticationResponse>(`${entorno.HOSTNAME}/auth/signin`, datos);
  }

  estaLogueado(){
    let token = sessionStorage.getItem(entorno.TOKEN_NAME);
    return token != null;
  }

  cerrarSesion(){
    sessionStorage.clear();
    this.router.navigate(['login']);
  }
}

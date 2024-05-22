import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { LoginService } from './login.service';
import { JwtHelperService } from '@auth0/angular-jwt';
import { entorno } from '../environment/entorno';

export const guardiaGuard: CanActivateFn = (route, state) => {
  const loginService = inject(LoginService);
  const router = inject(Router);
  const jwtHelper = inject(JwtHelperService);

  // 1. Verificamos si está logueado
  let rpta = loginService.estaLogueado();

  if(!rpta){
     console.log('no está logueado: false');
     loginService.cerrarSesion();
     return false;
  }else{
    // 2. Verificamos si el token no ha expirado
    let token = sessionStorage.getItem(entorno.TOKEN_NAME);
    if(!jwtHelper.isTokenExpired(token)){
      console.log("No ha expirado el token");
      return true;
    }else{
      loginService.cerrarSesion()
      return false;
    }
  }
};

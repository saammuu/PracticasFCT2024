import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { ContenidoComponent } from './components/contenido/contenido.component';
import { guardiaGuard } from './services/guardia.guard';

export const routes: Routes = [
    {"path":"", redirectTo:"/login", pathMatch:"full"},
    {"path": "login", component: LoginComponent},
    {"path": "contenido", component: ContenidoComponent,
        canActivate: [guardiaGuard]
    }
];

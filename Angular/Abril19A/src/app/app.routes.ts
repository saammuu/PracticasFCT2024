import { Routes } from '@angular/router';
import { InicioComponent } from './inicio/inicio.component';
import { QuienesSomosComponent } from './quienes-somos/quienes-somos.component';
import { DondeEstamosComponent } from './donde-estamos/donde-estamos.component';
import { ComentariosComponent } from './comentarios/comentarios.component';

export const routes: Routes = [
    {path: '', redirectTo: '/inicio', pathMatch: 'full' },
    {path: 'inicio', title: 'Inicio', component: InicioComponent},
    {path: 'quienes_somos', title: 'Quienes somos', component: QuienesSomosComponent},
    {path: 'donde_estamos', title: 'Donde estamos', component: DondeEstamosComponent},
    {path: 'comentarios', title: 'Comentarios', component: ComentariosComponent}
];

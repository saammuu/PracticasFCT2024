import { Routes } from '@angular/router';
import { ListaProductosComponent } from './components/lista-productos/lista-productos.component';
import { AltaProductosComponent } from './components/alta-productos/alta-productos.component';

export const routes: Routes = [
    {path:'listar', title:'Productos', component: ListaProductosComponent , 
    children: [
        {path: 'alta', title: 'Alta', component: AltaProductosComponent},
    ]},
];

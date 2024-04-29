import { Routes } from '@angular/router';
import { ListaProductosComponent } from './components/lista-productos/lista-productos.component';
import { AltaProductoComponent } from './components/alta-producto/alta-producto.component';

export const routes: Routes = [
    {path: '', component: ListaProductosComponent, children:[
        {path: 'alta', component: AltaProductoComponent},
        {path: 'edicion/:id', component:AltaProductoComponent}
    ]}
];

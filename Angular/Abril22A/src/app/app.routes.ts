import { Routes } from '@angular/router';
import { InmueblesComponent } from './inmuebles/inmuebles.component';
import { DetallesInmuebleComponent } from './detalles-inmueble/detalles-inmueble.component';
import { BlogComponent } from './blog/blog.component';
import { ArticuloComponent } from './articulo/articulo.component';

export const routes: Routes = [
    {path:'inmuebles', title:'Inmuebles', component: InmueblesComponent},
    {path:'detallesin/:id', title:'Detalles', component: DetallesInmuebleComponent},
    {path: 'blog', title:'Blog', component: BlogComponent},
    {path: 'articulo/:id', title: 'Articulo', component: ArticuloComponent}
];

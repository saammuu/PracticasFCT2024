import { Routes } from '@angular/router';
import { ListaEmpleadosComponent } from './components/lista-empleados/lista-empleados.component';
import { AltaEmpleadoComponent } from './components/alta-empleado/alta-empleado.component';
import { ModificaEmpleadoComponent } from './components/modifica-empleado/modifica-empleado.component';

export const routes: Routes = [
    {path: '', component: ListaEmpleadosComponent, children:[
        {path: 'alta', component: AltaEmpleadoComponent}, // es el formulario
        {path: 'modifica', component: ModificaEmpleadoComponent}
    ]}
];

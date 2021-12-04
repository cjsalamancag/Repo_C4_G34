import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [{ path: 'consultar', loadChildren: () => import('./clientes/consulta/consulta.module').then(m => m.ConsultaModule) }, { path: 'registro', loadChildren: () => import('./clientes/registro/registro.module').then(m => m.RegistroModule) }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

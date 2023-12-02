import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListadoComponent } from './videojuegos/listado/listado.component';
import { DetalleComponent } from './videojuegos/detalle/detalle.component';
import { ContactoComponent } from './contacto/contacto.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { LoginComponent } from './autenticacion/login/login.component';

const routes: Routes = [
  {path: '', component: ListadoComponent},
  {path: 'detalle/:id', component: DetalleComponent},
  {path: 'contacto', component: ContactoComponent},
  {path: 'about-us', component: AboutusComponent},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

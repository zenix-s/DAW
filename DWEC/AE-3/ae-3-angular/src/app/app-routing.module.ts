import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListadoComponent } from './videojuegos/listado/listado.component';
import { DetalleComponent } from './videojuegos/detalle/detalle.component';
import { ContactoComponent } from './contacto/contacto.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { LoginComponent } from './autenticacion/login/login.component';
import { AuthLogginGuard } from './guard/auth-loggin.guard';

const routes: Routes = [
  {path: '', component: ListadoComponent, canActivate: [AuthLogginGuard]},
  {path: 'detalle/:id', component: DetalleComponent, canActivate: [AuthLogginGuard]},
  {path: 'contacto', component: ContactoComponent, canActivate: [AuthLogginGuard]},
  {path: 'about-us', component: AboutusComponent, canActivate: [AuthLogginGuard]},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

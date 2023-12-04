import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListadoComponent } from './videojuegos/listado/listado.component';
import { DetalleComponent } from './videojuegos/detalle/detalle.component';
import { ContactoComponent } from './contacto/contacto.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { LoginComponent } from './autenticacion/login/login.component';
import { ListItemComponent } from './videojuegos/listado/list-item/list-item.component';
import { FormsModule } from '@angular/forms';
import { AsideComponent } from './components/aside/aside.component';

@NgModule({
  declarations: [
    AppComponent,
    ListadoComponent,
    DetalleComponent,
    ContactoComponent,
    AboutusComponent,
    LoginComponent,
    ListItemComponent,
    AsideComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { Component, OnInit } from '@angular/core';
import { ListItemComponent } from './list-item/list-item.component';
import { GameServiceService } from 'src/app/service/game-service.service';
import { Videojuego } from 'src/app/modelo/Videojuego';
import { AuthenticationService } from 'src/app/service/authentication.service';
import { User } from 'src/app/modelo/User';

@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.css'],
})

/**
 * encargado de gestionar la vista /
 * Se visualiza un listado de videojuegos a los cuales se pueden acceder para obtener mas detalles
 */
export class ListadoComponent implements OnInit {
  user!:User;
  games: Videojuego[] = [];
  constructor(private _gameService: GameServiceService, private authService:AuthenticationService) {}

  /**
   * Se hace uso del servicio GameServiceService para conseguir el listado completo de videojuegos
   */
  ngOnInit(): void {
    this.games = this._gameService.findAll();
    const activeUser = this.authService.getUser();
    if(activeUser){
      this.user = activeUser;
    }
  }
}

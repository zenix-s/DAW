import { Component, OnInit } from '@angular/core';
import { ListItemComponent } from './list-item/list-item.component';
import { GameServiceService } from 'src/app/service/game-service.service';
import { Videojuego } from 'src/app/modelo/Videojuego';

@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.css'],
})
export class ListadoComponent implements OnInit {
  games: Videojuego[] = [];
  constructor(private _gameService: GameServiceService) {}

  ngOnInit(): void {
    this.games = this._gameService.findAll();
  }
}

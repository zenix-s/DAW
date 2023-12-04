import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Videojuego } from 'src/app/modelo/Videojuego';
import { GameServiceService } from 'src/app/service/game-service.service';

@Component({
  selector: 'app-detalle',
  templateUrl: './detalle.component.html',
  styleUrls: ['./detalle.component.css'],
})

/**
 * Se encarga de gestionar la vista detalle/{id}
 */
export class DetalleComponent implements OnInit {
  game!: Videojuego | undefined;


  constructor(
    private _gameService: GameServiceService,
    private route: ActivatedRoute,
  ) {}

  /**
   * al iniciarse el componente se toma el id de los parametros y usando el servicio _gameService se busca y se almacena para su uso
   */
  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      const gameId = +params['id'];
      this.game = this._gameService.findById(gameId);
    });
  }
}

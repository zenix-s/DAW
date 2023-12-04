import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Videojuego } from 'src/app/modelo/Videojuego';
import { GameServiceService } from 'src/app/service/game-service.service';

@Component({
  selector: 'app-detalle',
  templateUrl: './detalle.component.html',
  styleUrls: ['./detalle.component.css'],
})
export class DetalleComponent implements OnInit {
  game!: Videojuego | undefined;

  constructor(
    private _gameService: GameServiceService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      const gameId = +params['id'];
      this.game = this._gameService.findById(gameId);
    });
  }
}

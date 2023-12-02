import { Injectable } from '@angular/core';
import { Videojuego } from '../modelo/Videojuego';

@Injectable({
  providedIn: 'root',
})
export class GameServiceService {
  private listGame: Videojuego[] = [
    {
      id: 1,
      titulo: 'Dark Souls',
      compania: 'FromSoftware',
      imagen: 'dark_souls.jpg',
      valoracionMedia: 4.5,
    },
    {
      id: 2,
      titulo: 'The Legend of Zelda: Breath of the Wild',
      compania: 'Nintendo',
      imagen: 'zelda_breath_of_the_wild.jpg',
      valoracionMedia: 4.8,
    },
    {
      id: 3,
      titulo: 'Blasphemous',
      compania: 'The Game Kitchen',
      imagen: 'blasphemous.jpg',
      valoracionMedia: 4.7,
    },
    {
      id: 4,
      titulo: 'Elden Ring',
      compania: 'FromSoftware',
      imagen: 'elden_ring.jpg',
      valoracionMedia: 4.9,
    },
    {
      id: 5,
      titulo: 'Dead Cells',
      compania: 'Motion Twin',
      imagen: 'dead_cells.jpg',
      valoracionMedia: 4.6,
    },
    {
      id: 6,
      titulo: 'Disco Elysium',
      compania: 'ZA/UM',
      imagen: 'disco_elysium.jpg',
      valoracionMedia: 4.8,
    },
    {
      id: 7,
      titulo: 'Sekiro: Shadows Die Twice',
      compania: 'FromSoftware',
      imagen: 'sekiro.jpg',
      valoracionMedia: 4.5,
    },
    {
      id: 8,
      titulo: 'Hollow Knight',
      compania: 'Team Cherry',
      imagen: 'hollow_knight.jpg',
      valoracionMedia: 4.7,
    },
    {
      id: 9,
      titulo: 'Celeste',
      compania: 'Maddy Makes Games',
      imagen: 'celeste.jpg',
      valoracionMedia: 4.5,
    },
    {
      id: 10,
      titulo: 'Cult of the Lamb',
      compania: 'Massive Monster',
      imagen: 'cult_of_the_lamb.jpg',
      valoracionMedia: 4.2,
    },
  ];

  public findAll() : Videojuego[]
  {
    return this.listGame;
  }

  public findById(id: Number) : Videojuego | undefined
  {
    return this.listGame.find(game => game.id === id);
  }

  constructor() {}
}

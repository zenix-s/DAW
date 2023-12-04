import { Injectable } from '@angular/core';
import { Videojuego } from '../modelo/Videojuego';

@Injectable({
  providedIn: 'root',
})

/**
 * Servicio encargado de gestionar operaciones crud con los videojuegos
 */
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
      titulo: 'Baldurs Gate 3',
      compania: 'Larian Studios',
      imagen: 'baldurs_gate_3.jpg',
      valoracionMedia: 4.9,
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

  /**
   * @returns Un listado con toda la lista de videojuegos
   */
  public findAll() : Videojuego[]
  {
    return this.listGame;
  }

  /**
   * 
   * @param id Id del videojuego a buscar
   * @returns retorna un objeto de la clase Videojuego cuyo id coicida. 
   * Rn caso de haberlo en caso contrario devolvera undefined
   */
  public findById(id: Number) : Videojuego | undefined
  {
    return this.listGame.find(game => game.id === id);
  }

  constructor() {}
}

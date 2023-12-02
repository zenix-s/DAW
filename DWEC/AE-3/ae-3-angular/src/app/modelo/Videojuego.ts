export class Videojuego {
  id: number;
  titulo: string;
  compania: string;
  imagen: string;
  valoracionMedia: number;

  constructor(
    id: number,
    titulo: string,
    compania: string,
    imagen: string,
    valoracionMedia: number
  ) {
    this.id = id;
    this.titulo = titulo;
    this.compania = compania;
    this.imagen = imagen;
    this.valoracionMedia = valoracionMedia;
  }
}

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.css'],
})

/**
 * Se encarga de manejar la vista /contacto
 */
export class ContactoComponent implements OnInit {
  isSended: boolean = false;
  constructor() {}

  /**
   * Activa el succesToast
   */
  contact(): void {
    this.isSended = true;
  }

  /**
   * Desactiva el succesToast
   */
  noContact(): void {
    this.isSended = false;
  }

  ngOnInit(): void {}
}

import { Component, Input, OnInit } from '@angular/core';
import { Videojuego } from 'src/app/modelo/Videojuego';

@Component({
  selector: 'app-list-item',
  templateUrl: './list-item.component.html',
  styleUrls: ['./list-item.component.css']
})
export class ListItemComponent implements OnInit {

  @Input() game! : Videojuego ;

  constructor() { 

  }

  ngOnInit(): void {

  }

}

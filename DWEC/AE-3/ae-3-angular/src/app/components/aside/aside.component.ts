import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/service/authentication.service';
@Component({
  selector: 'app-aside',
  templateUrl: './aside.component.html',
  styleUrls: ['./aside.component.css'],
})
export class AsideComponent implements OnInit {
  constructor(private authService: AuthenticationService) {}

  /**
   * Se encarga de usar el AuthenticationService para comprubar si hay un usuario logueado
   * @returns valor booleano en función de si hay un usuario registrado o no.
   */
  isLogged(): boolean {
    return this.authService.isLoggedIn();
  }

  logOut(): void {
    this.authService.logout();
  }

  ngOnInit(): void {}
}

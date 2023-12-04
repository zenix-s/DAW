import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/service/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  username: string = '';
  password: string = '';
  loginFailed: boolean = false;

  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {}

  /**
   * Haciendo uso de AuthenticationService comprueba si el usuario y contraseña son correctos.
   * En caso de serlos redirigira al usuario al listado de videojuegos.
   */
  login(): void {
    if (this.authService.login(this.username, this.password)) {
      console.log('funciona esta vivo');
      this.router.navigate(['/']);
    } else {
      console.log('fuck');
      this.loginFailed = true;
    }
  }

  /**
   * Resetea el valor de loginFailed para eliminar el toast
   */
  desactivateLoginFailed(): void {
    this.loginFailed = false;
  }

  ngOnInit(): void {}
}

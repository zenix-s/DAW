import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/service/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username: string = '';
  password: string = '';

  constructor(private authService: AuthenticationService, private router:Router) { }

  /**
   * Haciendo uso de AuthenticationService comprueba si el usuario y contraseña son correctos.
   * En caso de serlos redirigira al usuario al listado de videojuegos.
   */
  login():void{
    if(this.authService.login(this.username, this.password)){
      console.log("funciona esta vivo")
      this.router.navigate(['/'])
    }else{
      console.log("fuck")
    }
  }

  ngOnInit(): void {
  }

}

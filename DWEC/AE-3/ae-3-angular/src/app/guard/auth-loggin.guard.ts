import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthLogginGuard implements CanActivate {

  /**
   * 
   * @param authService Servicio encargado de manejar la sesion del usuario
   * @param router Objeto de la clase angular Router.
   */
  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {}
  
  /**
   * Se encargara de comprobar si hay una sesión a la hora de acceder a un direccionamiento protegido
   * En caso de no existir esta sesión devolvera al usuario a la pagina del login
   * @param route 
   * @param state 
   * @returns 
   */
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {
    if (this.authService.isLoggedIn()) {
      return true;
    } else {
      this.router.navigate(['/login']);
      return false;
    }
  }
}

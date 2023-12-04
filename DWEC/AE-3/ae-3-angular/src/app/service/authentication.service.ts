import { Injectable } from '@angular/core';
import { User } from '../modelo/User';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})

/**
 * Servicio encargado de manejar la sesión del usuario
 */
export class AuthenticationService {
  private isLogged = false;
  private user: User | undefined;

  constructor(private router: Router) {}
  users = [
    {
      userName: 'root',
      password: 'root',
    },
    {
      userName: 'user',
      password: 'user',
    },
  ];
  
  /**
   * Función encargada de comprobar la credenciales aportadas son validas.
   * Si ha encontrado las credenciales correctas establece el estado de la sesión como inciado.
   * Y almacena el username del usuario
   * @param userName el username a buscar entre los usuarios registrados
   * @param password La contraseña del usuario aportado
   * @returns un valor booleano en función de si ha encontrado unas credenciales validas o no
   */
  login(userName: string, password: string): boolean {
    const logUser: User | undefined = this.users.find(
      (user) => user.userName === userName
    );
    if (logUser && logUser.password === password) {
      this.isLogged = true;
      const loguser = new User(userName);
      this.user = loguser;
      return true;
    } else {
      this.isLogged = false;
      this.user = undefined;
      return false;
    }
  }

  /**
   * Se encarga de destruir la sesión del usuario
   */
  logout(): void {
    this.isLogged = false;
    this.user = undefined;
    this.router.navigate(['/login']);
  }

  /**
   * 
   * @returns Devuelve un booleano en función de si existe un usuario registrado o no
   */
  isLoggedIn(): boolean {
    return this.isLogged;
  }

  /**
   * Devolvera el usuario logueado en caso de que exista
   * @returns El usuario logueado
   */
  getUser(): User | undefined {
    if (this.user) {
      return this.user;
    }
    return undefined;
  }
}

import { Injectable } from '@angular/core';
import { User } from '../modelo/User';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
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

  logout(): void {
    this.isLogged = false;
    this.user = undefined;
    this.router.navigate(['/login']);
  }

  isLoggedIn(): boolean {
    return this.isLogged;
  }

  getUser(): User | undefined {
    if (this.user) {
      return this.user;
    }
    return undefined;
  }
}

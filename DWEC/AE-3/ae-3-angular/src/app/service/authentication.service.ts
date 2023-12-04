import { Injectable } from '@angular/core';
import { User } from '../modelo/User';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  private isLogged = false;
  private user: User | undefined;

  constructor() {}

  login(userName: string, password: string): boolean {
    if (userName === 'root' && password == 'root') {
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

  logout():void{
    this.isLogged = false
    this.user = undefined
  }

  isLoggedIn():boolean{
    return this.isLogged
  }

  getUser():User|undefined{
    if(this.user){
      return this.user
    }
    return undefined
  }
}

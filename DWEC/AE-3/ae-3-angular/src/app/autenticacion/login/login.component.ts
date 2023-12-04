import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username: string = '';
  password: string = '';

  constructor(private authService: AuthenticationService) { }

  login():void{
    if(this.authService.login(this.username, this.password)){
      console.log("funciona esta vivo")
    }else{
      console.log("fuck")
    }
  }

  ngOnInit(): void {
  }

}

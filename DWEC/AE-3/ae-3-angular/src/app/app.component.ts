import { Component } from '@angular/core';
import { AuthenticationService } from './service/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'ae-3-angular';

  constructor(public authService: AuthenticationService) {}
  logout(): void {
    this.authService.logout();
  }
}

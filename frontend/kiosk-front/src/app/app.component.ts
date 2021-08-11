import { Component } from '@angular/core';
import { TokenSecurityServiceService } from './services/token-security-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'kiosk-front';

  constructor(private securityToken: TokenSecurityServiceService){

  }

  ngOnInit(){
  }
  
  login(){
    this.securityToken.login();
  }
}

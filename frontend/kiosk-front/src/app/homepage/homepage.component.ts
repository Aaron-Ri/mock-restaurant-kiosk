import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Food } from '../models/food';
import { CartService } from '../services/cart.service';
import { TokenSecurityServiceService } from '../services/token-security-service.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  cartItems: Array<Food>;

  constructor(private cartService: CartService, private router:Router, private securityToken: TokenSecurityServiceService) { 
    this.cartItems = cartService.getItems();
  }
  ngOnInit(): void {
  }

  gotoMenu(){
    this.router.navigate(['/menu']);
  }

  gotoReceipt(){
    this.router.navigate(['/receipt']);
  }
}

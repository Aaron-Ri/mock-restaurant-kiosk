import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../services/cart.service';
import { Food } from '../models/food';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartItems: Food[];
  orderSubTotal: number = 0;

  constructor(private cartService: CartService, private router:Router) {
    this.cartItems = this.cartService.items;
   }

  ngOnInit(): void {
  }

  ngDoCheck(){    
    this.orderSubTotal = this.cartService.total;
  }

  gotoReceipt(){
    this.router.navigate(['/receipt']);
  }

}

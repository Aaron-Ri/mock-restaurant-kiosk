import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from '../models/order';
import { CartService } from '../services/cart.service';
import { OrderSubmitService } from '../services/order-submit.service';

@Component({
  selector: 'app-thank-you-page',
  templateUrl: './thank-you-page.component.html',
  styleUrls: ['./thank-you-page.component.css']
})
export class ThankYouPageComponent implements OnInit {

  order:Order;

  constructor(private cartService: CartService, private orderService:OrderSubmitService, private router:Router) {
    this.order = orderService.getLastOrder();
    console.log(this.orderService.getLastOrder());
   }

  ngOnInit(): void {
    //this.cartService.clearCart();
    this.order = this.orderService.getLastOrder();
    if(this.order.orderId < 0){
      this.router.navigate(['/homepage']);
    }
  }


}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Food } from '../models/food';
import { Order } from '../models/order';
import { CartService } from '../services/cart.service';
import { OrderSubmitService } from '../services/order-submit.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-receipt',
  templateUrl: './receipt.component.html',
  styleUrls: ['./receipt.component.css']
})
export class ReceiptComponent implements OnInit {

  cartItems: Array<Food> = [];
  orderSubTotal: number = 0;
  orderTax: number = 0;
  orderGrandTotal: number = 0;

  constructor(private cartService: CartService, private orderService: OrderSubmitService, private router:Router, private location:Location) {
    this.cartItems = cartService.items;
   }

  ngOnInit(): void {
  }

  ngDoCheck(){    
    this.orderSubTotal =this.cartService.total;
    this.orderTax = this.cartService.tax;
    this.orderGrandTotal = this.cartService.totalAndTax;
  }

  removeItemFromcart(item:Food){
    //console.log("item being removed from cart: "+item.foodName);
    this.cartService.removeItem(item);
  }

  submitOrder(){

    let currentOrder: Order ={
      "orderId":0,
      "orderTotalBeforeTax": this.orderSubTotal,
      "orderTax": this.orderTax,
      "orderAfterTax":this.orderGrandTotal,
      "orderItems": this.cartItems
    };

    let completedOrder = this.orderService.submitOrder(currentOrder).subscribe(
      (result)=>
        {console.log(result);
          this.cartService.clearCart();
          this.orderService.setLastOrder(result);
          this.router.navigate(['/thankyoupage']);
        }
      );

  }


  backButton(): void{

    this.location.back();

  }

}

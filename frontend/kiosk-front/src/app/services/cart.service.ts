import { Injectable } from '@angular/core';
import { Food } from '../models/food';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor() { }

  taxAmount: number = 0.07;
  items: Array<Food> = [];
  total: number = 0;
  tax: number = 0;
  totalAndTax: number = 0;
  


  addItem(food: Food): void{
    //console.log("food added to cart");
      this.items.push(food);
      this.calculateTotal();
  }

  removeItem(food: Food): void{
      this.items.splice((this.items.indexOf(food)),1);
      this.calculateTotal();
  }

  calculateTotal():void{
    let tempNumber: number = 0;
    this.items.forEach(foodItem => tempNumber += foodItem.foodPrice);
    this.total = tempNumber;
    this.tax = this.total * this.taxAmount;
    this.totalAndTax = this.total + this.tax;
    //console.log("test that things are being calculated correctly: "+this.total);
  }

  getItems(): Array<Food>{
    return this.items;
  }

  clearCart():void{
    this.items.splice(0,this.items.length);
    this.calculateTotal();
  }
}

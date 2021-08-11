import { Component, OnInit } from '@angular/core';
import { CartService } from '../services/cart.service';
import { Food } from '../models/food';
import { FoodFetcherService } from '../services/food-fetcher.service';
// import { Popover } from 'node_modules/bootstrap/dist/js/bootstrap.esm.min.js';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  foodItems: Array<Food> = [];

  testFood: Food = {
    "foodId": 1,
    "foodName": "Double Cheese Burger",
    "foodPrice": 4.99,
    "foodCatagory": "MAIN",
    "foodDescription": "Two layers of beef topped with cheese, onion, tomato, lettuce and pickles. all held together with delicious wheat buns.",
    "foodNutritionInfo": ""
    };

  constructor(private cartService: CartService, private foodFetcher: FoodFetcherService) { }

  ngOnInit(): void {
    this.foodFetcher.getAllFood().subscribe(
      (response) => {
        this.foodItems = response;
      }
    );
    
    
  }

  addItemToCart(food: Food){
    //this.cartService.addItem(this.testFood);

    //let food:Array<Food>; 
    // this.foodFetcher.getAllFood().subscribe(
    //   (response) => {
    //     food = response;
    //     food.forEach((foodItem)=>{this.cartService.addItem(foodItem)});
    //   }
    // );

    this.cartService.addItem(food);


  }

}

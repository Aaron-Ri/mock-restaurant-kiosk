import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Order } from '../models/order';
import { Observable, of } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class OrderSubmitService {

  private lastOrder: Order = {'orderId': -1, 'orderAfterTax': -1, 'orderItems':[], 'orderTax': -1, 'orderTotalBeforeTax': -1};

  private orderUrl = 'http://localhost:9011/order';  // URL to web api, for now it is local host.

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) {
   }

   submitOrder(order:Order): Observable<Order> {
    return this.http.post<Order>(this.orderUrl+'/new', order, this.httpOptions);
  }

  setLastOrder(order:Order):void{
    this.lastOrder = order;
  }

  getLastOrder(): Order{
    return this.lastOrder;
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Food } from '../models/food';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FoodFetcherService {

  private foodUrl = 'http://localhost:9011/food';  // URL to web api, for now it is local host.

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) {
   }

   getAllFood(): Observable<Food[]> {
    return this.http.get<Food[]>(this.foodUrl+'/all')
  }

}

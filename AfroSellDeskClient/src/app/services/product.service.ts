import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Product } from '../model/Product';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
url:string = 'http://localhost:3300/products';


  constructor(private http:HttpClient) { }
  getProducts():Observable<Product[]>{

    return this.http.get<Product[]>(this.url);
  }

}

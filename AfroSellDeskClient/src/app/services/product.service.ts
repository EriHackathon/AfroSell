import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Product } from '../model/Product';
import { Observable } from 'rxjs';
import { ProductAddComponent } from '../components/product-add/product-add.component';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}
@Injectable({
  providedIn: 'root'
})
export class ProductService {
url = 'http://localhost:3300/products';
productAdd: ProductAddComponent;
product: Product;
addEdit: boolean;

  constructor(private http: HttpClient) { }
  getProducts(): Observable<Product[]> {

    return this.http.get<Product[]>(this.url);
  }

  addProduct(product: Product): Observable<any> {
    console.log('adding on server');
    return this.http.post(this.url, product, httpOptions);
  }

  editProduct(product: Product): Observable<any> {

    const finUrl = `${this.url}/${product.productId}` ;
    console.log(finUrl) ;
    return this.http.put(finUrl, product, httpOptions);
  }

  deleteProduct(product: Product): Observable<any> {
    console.log(product.productName + 'deleting');
    const finUrl = `${this.url}/${product.productId}` ;
    return this.http.delete(finUrl, httpOptions) ;
  }

}

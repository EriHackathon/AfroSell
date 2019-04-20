import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Product } from '../model/Product';
import { Observable } from 'rxjs';
import { catchError, tap} from 'rxjs/operators';
import { ProductAddComponent } from '../admin/components/product-add/product-add.component';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};
@Injectable({
  providedIn: 'root'
})
export class ProductService {
url = 'http://localhost:3300/products';
productAdd: ProductAddComponent;
product: Product;
addEdit = false;

  constructor(private http: HttpClient) { }
  private errorHandler(err: HttpErrorResponse) {
   let errMsg: string ;
   errMsg = err.error.status;
  
   return Observable.throw(errMsg);
  }
  getProducts(): Observable<Product[]> {
console.log('getting all products...');
return this.http.get<Product[]>(this.url).pipe(
      tap(data => data),
      catchError(this.errorHandler));
  }

  getProduct(productId: number): Observable<any> {
    console.log('getting a product Detail');
    return this.http.get<Product>(`${this.url}/${productId}`);
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

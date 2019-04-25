import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/Product';
import { ProductDetailComponent } from '../product-detail/product-detail.component';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
goToDetail(product: Product) {
  console.log(product.productName + 'from home');
}
signUp(): void {
  console.log('to sign up');
  

}
}

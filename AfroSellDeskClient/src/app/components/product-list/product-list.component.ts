import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { CartServiceService } from '../../services/cart-service.service';
import { Product } from '../../model/Product';
@Component({

  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
productList: Product[];
productListError = false;
  constructor(private ps: ProductService, private cs: CartServiceService) { }


  ngOnInit() {
  this.ps.getProducts().subscribe(
  (products) => {
    this.productList = products;

  },
  (error) => {
  this.productListError = true;
  console.log('products not found' + error); }
  );

  }
  addToCart(product: Product) {
    console.log('Adding to Cart...' + `${product.productName} - ${product.price}`);

  }
  goToDetail(product: Product){
    console.log('event from list...to detail');
  }

}

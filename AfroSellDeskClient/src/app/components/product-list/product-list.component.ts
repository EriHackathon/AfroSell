import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../services/product.service';

import { Product } from '../../model/Product';
@Component({

  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
productList: Product[];
productListError = false;
  constructor(private ps: ProductService) { }


  ngOnInit() {
  this.ps.getProducts().subscribe(
  (products) => {
    this.productList = products;

  },
  (error) => {
  this.productListError = true;
  console.log('products not found'); }
  );

  }
  editProduct(product: Product) {
    console.log('edit action...' + `${product.productName} - ${product.price}`);
  }
  deleteProduct(product: Product) {
    console.log('delete action...' ) ;
    this.ps.deleteProduct(product).subscribe(() => {
       console.log('del worked');
       this.productList = this.productList.filter(pro => pro.productId !== product.productId);
    });
  }
}

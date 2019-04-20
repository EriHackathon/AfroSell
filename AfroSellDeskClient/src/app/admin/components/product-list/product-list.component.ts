import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../../services/product.service';

import { ProductAddComponent } from '../../components/product-add/product-add.component' ;

import { Product } from '../../../model/Product';
@Component({

  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
productList: Product[];
productListError = false;
  constructor(private ps: ProductService, private pac: ProductAddComponent) { }


  ngOnInit() {
  this.ps.getProducts().subscribe(
  (products) => {
    this.productList = products;

  },
  (error) => {
  this.productListError = true;
  const x: string = error as any;
  console.log( x ); }
  );

  }
  editProduct(product: Product) {
    console.log('edit action...' + `${product.productName} - ${product.price}`);
    this.pac.editProduct(product);
  }
  deleteProduct(product: Product) {
    console.log('delete action...' ) ;
    //server
    this.ps.deleteProduct(product).subscribe(() => {
       console.log('deleting worked on server');
       this.productList = this.productList.filter(pro => pro.productId !== product.productId);
    });
  }
}

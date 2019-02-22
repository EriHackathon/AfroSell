import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../services/product.service';

import { Product } from '../../model/Product';
@Component({

  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
productList:Product[];
productListError:boolean= false;
  constructor(private ps: ProductService) { }


  ngOnInit() {
  this.ps.getProducts().subscribe(
  (products) => {
    this.productList = products;

  },
  (error)=>{
  this.productListError =true;
  console.log('products not found')}
  );

  }

ngOnDestroy(): void{
//unsubscribe eventEmitters and
}
}

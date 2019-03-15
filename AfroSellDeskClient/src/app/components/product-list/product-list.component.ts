import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../services/product.service';

import { Product } from '../../model/Product';
@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
productList:Product[];
  constructor(private ps:ProductService) { }

  ngOnInit() {
  this.ps.getProducts().subscribe(products =>{
    this.productList = products;

  });

  }

}

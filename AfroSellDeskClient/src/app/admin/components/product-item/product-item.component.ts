import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Product } from '../../../model/Product';
import { ProductService } from '../../../services/product.service';

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {
  productToDe: Product;
@Input() productItem: Product;
@Output() deleteProduct: EventEmitter<Product> = new EventEmitter();
@Output() editProduct: EventEmitter<Product> = new EventEmitter();
  constructor(private productItemService: ProductService) { }

  ngOnInit() {
  }
delete(product: Product): void {
  this.deleteProduct.emit(product) ;
  }

edit(product: Product): void {
  console.log('edit...' + product.productName);
  this.editProduct.emit(product) ;
  this.productItemService.product = product;
  this.productItemService.addEdit = true;
}

}

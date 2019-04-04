import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Product } from '../../model/Product';
import { ProductService } from '../../services/product.service';
import { CartServiceService } from '../../services/cart-service.service';
@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {
  productToDe: Product;
@Input() productItem: Product;
@Output() addToCart: EventEmitter<Product> = new EventEmitter();
@Output() goToDetail: EventEmitter<Product> = new EventEmitter();
  constructor(private productItemService: ProductService, private cartService: CartServiceService) { }

  ngOnInit() {
  }

  addCart(product: Product): void {
  console.log('adding to cartfrom item...' + product.productName);
  this.addToCart.emit(product) ;
  // more action
}
goDetatil(productItem: Product) {
  this.goToDetail.emit(productItem);
  console.log(productItem.productName + 'from event Emitter');
}

}

import { Component, OnInit,Input } from '@angular/core';
import { Product } from '../../model/Product';
import { ProductService } from '../../services/product.service';
@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {
@Input() productItem: Product;

  constructor(private productItemService: ProductService) { }

  ngOnInit() {
  }
delete(product: Product): void {
   this.productItemService.deleteProduct(product).subscribe(() => {
   console.log('del worked');
 });
}

edit(product: Product): void {
  console.log('edit...' + product);
}
}

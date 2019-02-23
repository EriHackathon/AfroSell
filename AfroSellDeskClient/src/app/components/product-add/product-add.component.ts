import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router' ;
import { ProductService } from '../../services/product.service' ;
import { Product } from '../../model/Product' ;
@Component({
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {
  productName: string ;
  productType: string;
  productCategory: string;
  productPrice: number;
  productImage: string;
  productDiscription: string;
  addResult  = '';
  addEdit = 'Add';
  constructor(private prodService: ProductService, private prod: Product, private router: Router) {
    this.addEdit = 'Add' ;
   }

  ngOnInit() {
      if (this.prodService.product !== undefined) {
      this.productName = this.prodService.product.productName;
      this.productCategory = this.prodService.product.productCategory;
      this.productType = this.prodService.product.productType ;
      this.productImage = this.prodService.product.productImage;
      this.productPrice = this.prodService.product.price;
      this.productDiscription = this.prodService.product.productDiscription;
      this.addEdit = 'Edit' ;
    }
  }
onSubmit(submittedValue): void {
if (submittedValue.invalid) {
  return;
}
console.log('what');
console.log(submittedValue.value);
this.prod.productName = submittedValue.value.productName;
this.prod.productType = submittedValue.value.productType;
this.prod.productImage = submittedValue.value.productImage;
this.prod.productCategory = submittedValue.value.productDiscription ;
this.prod.productDiscription = submittedValue.value.productDiscription;
this.prod.price = submittedValue.value.productPrice ;
this.prod.productName = submittedValue.value.productName;


this.prodService.addProduct(this.prod).subscribe( res => {
  console.log('done adding');
  this.addResult = 'done adding';
});
}
editProduct(product: Product): void {
  console.log('editing on add page!!');
  this.router.navigate(['productAdd']);
}


}

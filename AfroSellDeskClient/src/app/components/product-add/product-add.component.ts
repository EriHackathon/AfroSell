import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product.service' ;
import { Product } from '../../model/Product' ;
@Component({
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {
  productName: string;
  addResult  = '';
  constructor(private prodService: ProductService, private prod: Product) { }

  ngOnInit() {
  }
onSubmit(submittedValue): void{
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
});
}



}

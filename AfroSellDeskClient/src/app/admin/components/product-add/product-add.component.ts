import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router' ;

import {FormGroup, Validators, FormBuilder} from '@angular/forms';
import { ProductService } from '../../../services/product.service' ;
import { Product } from '../../../model/Product' ;



@Component({
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {
  formProduct: FormGroup;
  productName: string ;
  productType: string;
  productCategory: string;
  price: string;
  productImage: string;
  productDiscription: string;
  addResult  = '';
  addEdit = false;

  constructor(private prodService: ProductService, private prod: Product, private formBuilder: FormBuilder, private router: Router) {
   // this.addEdit = this.prodService.addEdit ;
    this.formProduct = this.formBuilder.group({
      productId: [null, null],
      productName: [null, Validators.required],
      productCategory: [null, Validators.required],
      productType: [null, Validators.required ],
      productImage:  [null, Validators.required ],
      price: [null, Validators.required ],
      productDiscription: [null, Validators.required ],
      dateCreated: [null, null],
      dateDeleted: [null, null]
   });
   }

    ngOnInit() {
      console.log('init...');
      if (this.prodService.addEdit) {
     console.log('tur?');
     this.formProduct.setValue(this.prodService.product);
     this.addEdit = true;
      } else {
        this.addEdit = false;
      }

  }

onSubmit(submittedValue): void {

if (this.addEdit) {
  this.prodService.editProduct(this.formProduct.value).subscribe( res => {
    console.log('done Editing');
    this.addResult = 'done editing';
    this.addEdit = false;
    this.prodService.addEdit = false;
  }, err => {
    console.log('can not edit');
    this.formProduct.setErrors({
      error: true
    });
  });
} else {
  this.prodService.addProduct(this.formProduct.value).subscribe( res => {
    console.log('done adding');
    this.addResult = 'done adding...';
  }, err => {
    console.log('can not add' + err.error.error);
    this.formProduct.setErrors({
      error: true
    });
  });
}

}
editProduct(product: Product): void {
  console.log('editing on add page!!');
  this.router.navigateByUrl('admin/productAdd');
}
onCancel(): void {
  console.log('cancel...');
}
 ngOnDestroy(): void {
  // Called once, before the instance is destroyed.
  // Add 'implements OnDestroy' to the class.
  console.log('Product add detrory');
  this.addEdit = false;
  this.prodService.addEdit = false;
  this.prodService.product = null;
}
isActive(): boolean {
  return false;
}

}

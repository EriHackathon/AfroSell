import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router' ;

import {FormGroup, Validators, FormBuilder} from '@angular/forms';
import { ProductService } from '../../services/product.service' ;
import { Product } from '../../model/Product' ;
import { ProductFormValidators } from './product.validator';



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
  addEdit: boolean;

  constructor(private prodService: ProductService, private prod: Product, private formBuilder: FormBuilder, private router: Router) {
    this.addEdit = this.prodService.addEdit ;
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
   if (this.prodService.addEdit) {
        this.formProduct.setValue(this.prodService.product);
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
    this.addResult = 'done adding';
  }, err => {
    console.log('can not add');
    this.formProduct.setErrors({
      error: true
    });
  });
}

}
editProduct(product: Product): void {
  console.log('editing on add page!!');
  this.router.navigate(['productAdd']);
}
onCancel(): void {
  console.log('cancel...');
}

}

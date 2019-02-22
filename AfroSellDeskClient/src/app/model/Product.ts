import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class Product {
  productId: number;
  productName: string;
  productCategory: string;
  productType: string;
  productImage: string;
  price: number;
  productDiscription: string;
  dateCreated: string;
  dateDeleted: string;

}

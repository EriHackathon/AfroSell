import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { Product } from 'src/app/model/Product';
import { ProductService } from 'src/app/services/product.service';
@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit, OnDestroy {
 res: number;
 detail: any;
 product: Product;
name : string;
  constructor(private route: ActivatedRoute, private router: Router, private ps: ProductService) { }

  ngOnInit() {

  this.detail =  this.route.params.subscribe((params: Params) => {
      // this.forum = this.forumsService.forum(params['forum_alias']);
      // if (!this.forum) this.router.navigate(['/not-found']);
     this.res = +params.id;
     console.log(params.id);
     this.ps.getProduct(params.id).subscribe(
      (product) => {
        this.product = product;
        this.name = this.product.productName
      }
    );
      });

 


  }
  // goToDetail(product: Product) {
  //   this.name = product.productName;
  //   console.log('someactions');
  // }
  ngOnDestroy(): void {
    // Called once, before the instance is destroyed.
    // Add 'implements OnDestroy' to the class.
    this.detail.unsubscribe();

  }

}

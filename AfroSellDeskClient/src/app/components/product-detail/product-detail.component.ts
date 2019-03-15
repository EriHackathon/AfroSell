import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, Params } from '@angular/router';
@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
 res: number;
  constructor(private route: ActivatedRoute, private router: Router,) { }

  ngOnInit() {
    
    this.route.params.subscribe((params: Params) => {
      // this.forum = this.forumsService.forum(params['forum_alias']);
      // if (!this.forum) this.router.navigate(['/not-found']);
     this.res = +params['id'];
      console.log(params['id']);
      });
  }

}

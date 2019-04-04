import { Component } from '@angular/core';
import { Product } from './model/Product';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],

})
export class AppComponent {
  title = 'AfroSellDeskClient from clSS';
  tap: string ;
  goToDetail(product: Product){
    console.log('event from AppComponent...to detail')
  }
}

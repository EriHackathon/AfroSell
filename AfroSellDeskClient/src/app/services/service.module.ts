import { NgModule } from '@angular/core';
import { ProductService } from './product.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
    imports: [
        HttpClientModule
    ],
    declarations: [],
    providers: [
        ProductService
    ],
    exports: []
  })
  export class ServiceModule {
  }
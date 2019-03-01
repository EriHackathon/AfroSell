import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material';


import { NgModule } from '@angular/core';
import { HttpClientModule  } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductService } from './services/product.service';
import { ProductItemComponent } from './components/product-item/product-item.component';
import { ProductAddComponent } from './components/product-add/product-add.component';
import { ProductHeaderComponent } from './components/product-header/product-header.component';
import {MatButtonModule, MatCheckboxModule} from '@angular/material';
@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductItemComponent,
    ProductAddComponent,
    ProductHeaderComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatDialogModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  exports: [MatButtonModule, MatCheckboxModule],
  providers: [
    ProductService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material';


import { NgModule } from '@angular/core';
import { HttpClientModule  } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from './material.module';

import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductService } from './services/product.service';
import { ProductItemComponent } from './components/product-item/product-item.component';
import { ProductAddComponent } from './components/product-add/product-add.component';
import { ProductHeaderComponent } from './components/product-header/product-header.component';
import { AfroNavComponent } from './components/afro-nav/afro-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductItemComponent,
    ProductAddComponent,
    ProductHeaderComponent,
    AfroNavComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    LayoutModule,
    MaterialModule
  ],
  providers: [
    ProductService,
    ProductAddComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

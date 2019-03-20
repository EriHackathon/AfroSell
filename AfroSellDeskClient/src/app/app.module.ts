import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';



import { NgModule } from '@angular/core';
import { HttpClientModule  } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from './material.module';

import { AppComponent } from './app.component';
import { ProductService } from './services/product.service';
import { ProductHeaderComponent } from './components/product-header/product-header.component';
import { AfroNavComponent } from './components/afro-nav/afro-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { ProductDetailComponent } from './components/product-detail/product-detail.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { HomeComponent } from './components/home/home.component';
import { RouteGuard} from './guards/RouteGuard';
import { AdminModule } from './admin/admin.module';
import { ServiceModule } from './services/service.module';
@NgModule({
  declarations: [
    AppComponent,
    ProductHeaderComponent,
      AfroNavComponent,
      ProductDetailComponent,
      SignInComponent,
      SignUpComponent,
      HomeComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    LayoutModule,
    MaterialModule,
    AdminModule,
    ServiceModule
  ],
  providers: [
    ProductService,
    RouteGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

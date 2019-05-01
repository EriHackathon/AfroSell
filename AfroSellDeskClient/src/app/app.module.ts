import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';



import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS  } from '@angular/common/http';
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
import { ProductItemComponent} from './components/product-item/product-item.component';
import {ProductListComponent} from './components/product-list/product-list.component';

import { RouteGuard} from './guards/RouteGuard';
import { AdminModule } from './admin/admin.module';
import { ServiceModule } from './services/service.module';
import { ProductAddComponent } from './admin/components/product-add/product-add.component';
import { FakeBackEnd } from './helpers/fake-back-end';
import { ProfileComponent } from './components/profile/profile.component';
import { JwtInterceptor } from './guards/JwtInterceptor';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { RegisterComponent } from './components/register/register.component';
@NgModule({
  declarations: [
    AppComponent,
    ProductHeaderComponent,
      AfroNavComponent,
      ProductListComponent,
      ProductItemComponent,
      ProductDetailComponent,
      SignInComponent,
      SignUpComponent,
      HomeComponent,
      ProfileComponent,
      WelcomeComponent,
      RegisterComponent
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
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptor,
      multi: true
      },
       {
      provide: HTTP_INTERCEPTORS,
      useClass: FakeBackEnd,
      multi: true
      },
        RouteGuard,
    ProductService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

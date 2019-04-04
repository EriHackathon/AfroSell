import { NgModule } from '@angular/core';
import { AdminComponent } from './components/admin/admin.component';
import { AdminRoutingModule } from './admin-routing.module';
import { MaterialModule } from '../material.module';
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductItemComponent } from './components/product-item/product-item.component';
import { ProductAddComponent } from './components/product-add/product-add.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LayoutModule } from '@angular/cdk/layout';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouteGuard } from '../guards/RouteGuard';
@NgModule({
    imports: [
        BrowserModule,
    BrowserAnimationsModule,
        AdminRoutingModule,
        MaterialModule,
        FormsModule,
        ReactiveFormsModule,
        LayoutModule
    ],
    declarations: [
        AdminComponent,
        ProductAddComponent,
        ProductListComponent,
        ProductItemComponent
        ],
        providers: [
            ProductAddComponent,
            RouteGuard
          ],
    exports: [
        AdminComponent
    ]
  })
  export class AdminModule {
  }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import { ProductAddComponent } from './components/product-add/product-add.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { RouteGuard } from '../guards/RouteGuard';
import { Role } from '../model/Role';
import { ProfileComponent } from '../components/profile/profile.component';
import { ProductDetailComponent } from '../components/product-detail/product-detail.component';
import { SignUpComponent } from '../components/sign-up/sign-up.component';

const routes: Routes = [
    { path: 'admin', component: AdminComponent, canActivate: [RouteGuard],
    data: { roles: [Role.Admin] },
    children: [
             { path: 'productAdd', component: ProductAddComponent},
             { path: 'list', component: ProductListComponent},
             { path: 'product-detail/:id', component: ProductDetailComponent},
             
             { path: 'profile', component: ProfileComponent}
            ]
}
  ];

@NgModule({
    imports: [
      RouterModule.forChild(routes)
    ],
    exports: [
      RouterModule
    ]
  })
  export class AdminRoutingModule {
  }

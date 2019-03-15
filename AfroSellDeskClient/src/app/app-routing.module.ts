import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductAddComponent } from './components/product-add/product-add.component';
import { ProductDetailComponent } from './components/product-detail/product-detail.component';
import {SignInComponent} from './components/sign-in/sign-in.component';
import {SignUpComponent} from './components/sign-up/sign-up.component';
const routes: Routes = [
  { path: '',
  component: ProductListComponent
  },
  {
    path: 'product', redirectTo: '', pathMatch: 'full'
  },
  {
    path: 'product-detail/:id',
    component: ProductDetailComponent
  },
{
path: 'productAdd',
component: ProductAddComponent
},
{
  path: 'signIn',
  component: SignInComponent
},
{
  path: 'signUp',
  component: SignUpComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

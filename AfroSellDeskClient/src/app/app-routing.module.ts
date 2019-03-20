import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductDetailComponent } from './components/product-detail/product-detail.component';
import {SignInComponent} from './components/sign-in/sign-in.component';
import {SignUpComponent} from './components/sign-up/sign-up.component';
import {HomeComponent} from './components/home/home.component';
import {RouteGuard} from './guards/RouteGuard';
const routes: Routes = [
  { path: '', component: HomeComponent,
   children: [
      { path: 'product-detail/:id', component: ProductDetailComponent}

    ]

}
  // {
  //   path: 'home',
  //   component: HomeComponent
  //   // children: [
  //   // // { path: '', redirectTo: 'product', pathMatch: 'full'},
  //   // { path: 'product', component: ProductListComponent},
  //   // { path: 'product-detail/:id', component: ProductDetailComponent},
  //   // { path: 'productAdd', component: ProductAddComponent}
  //   // ]
  // },
,
{
  path: 'signIn',
  component: SignInComponent
},
{
  path: 'signUp',
  component: SignUpComponent
}
];
export const routeRoutedComponents = [
  HomeComponent
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductDetailComponent } from './components/product-detail/product-detail.component';
import {SignInComponent} from './components/sign-in/sign-in.component';
import {SignUpComponent} from './components/sign-up/sign-up.component';
import {HomeComponent} from './components/home/home.component';
import {RouteGuard} from './guards/RouteGuard';
import {ProductListComponent} from './components/product-list/product-list.component';
import { Role } from './model/Role';
import { ProfileComponent } from './components/profile/profile.component';
const routes: Routes = [
  { path: '', component: HomeComponent, canActivate: [RouteGuard],
  data: {roles: [Role.User]},
   children: [
      { path: '', component: ProductListComponent},
      { path: 'product-detail/:id', component: ProductDetailComponent},
      { path: 'profile', component: ProfileComponent}

    ]

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
export const routeRoutedComponents = [
  HomeComponent
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

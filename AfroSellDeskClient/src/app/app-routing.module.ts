import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductAddComponent } from './components/product-add/product-add.component';

const routes: Routes = [
  { path: '',
  component: ProductListComponent
  },
{
path: 'productAdd',
component: ProductAddComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

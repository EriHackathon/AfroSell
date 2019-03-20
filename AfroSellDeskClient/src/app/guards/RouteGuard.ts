import {Injectable} from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import {Observable} from 'rxjs';
import { ProductService } from '../services/product.service';

@Injectable()
export class RouteGuard implements CanActivate {

    constructor(private router: Router, private ps: ProductService) {

    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
  // if (this.ps.addEdit) {
//         return true;
//    } else {
//    this.router.navigate(['/signIn'], {
//         queryParams: {
//             return: state.url
//         }
//     });
//    return false;
// }
return true;
    }

}

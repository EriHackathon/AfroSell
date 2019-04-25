import {Injectable} from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import {Observable} from 'rxjs';
import { ProductService } from '../services/product.service';
import { AuthenticationService } from '../services/authentication.service';

@Injectable()
export class RouteGuard implements CanActivate {

    constructor(private router: Router, private auth: AuthenticationService) {

    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean  {
      const currentUser = this.auth.currentUserValue;
      console.log(currentUser);
      if (currentUser) {
         // if current role
        if (route.data.roles && route.data.roles.indexOf(currentUser.role) === -1) {
          // role not authorised so redirect to home page
          this.router.navigate(['/signIn'], {
            queryParams: {
              return: state.url
            }
          });
          return false;
      }
        return true;
      } else {
      this.router.navigate(['/signIn'], {
        queryParams: {
          return: state.url
        }
      });
      return false;
    }

    }


}

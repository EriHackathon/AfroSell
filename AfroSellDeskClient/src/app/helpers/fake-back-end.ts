import { Injectable } from '@angular/core';
import { HttpRequest, HttpResponse, HttpHandler, HttpEvent, HttpInterceptor, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { User } from '../model/User';
import { Role } from '../model/Role';
const users: User[] = [
    { id: 1, userName: 'admin', password: 'admin', firstName: 'Admin', lastName: 'User', role: Role.Admin, token: '' },
    { id: 2, userName: 'aelaf', password: 'ted', firstName: 'aelaf', lastName: 'ted', role: Role.Admin, token: '' },
    { id: 3, userName: 'dave', password: 'deva', firstName: 'dave', lastName: 'deva', role: Role.User, token: '' }
];
@Injectable()
export class FakeBackEnd implements HttpInterceptor {
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const request = req.clone();
        console.log('intercepting... ' + req.url);
      // return Observable.throw('Error message');
      //  return error('request');
        if (request.method === 'POST' && request.url.endsWith('/users/authenticate')) {
          const user = users.find(x => x.userName === request.body.userName && x.password === request.body.password);
          console.log('posting..user name ' + request.body);
          if (!user) { return error('user Not found'); }
          return ok({
            id: user.id,
            userName: user.userName,
            firstName: user.firstName,
            lastName: user.lastName,
            role: user.role,
            token: 'fake-jwt-token.${user.role}'
        });
        }
        console.log('non fake auth job');
        return next.handle(req);
          // private helper functions

        function ok(body) {
            return of(new HttpResponse({ status: 200, body }));
        }

        function unauthorised() {
            return throwError({ status: 401, error: { message: 'Unauthorised' } });
        }

        function error(message) {
            return throwError({ status: 400, error: { message } });
        }
    }

}


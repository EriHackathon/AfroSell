import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, from } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../model/User';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
@Injectable({providedIn: 'root'})
export class AuthenticationService {
  private isLoggedIn = false;
   
    private currentUserSubject: BehaviorSubject<User>;
    public currentUser: Observable<User>;
    constructor(private http: HttpClient, private router: Router) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
    }
    public get currentUserValue(): User {
        return this.currentUserSubject.value;
    }

    public makeUserAuthentic(userx: User): Observable<any> {

        return this.http.post<any>('http://localhost:3300/users/authenticate', userx, httpOptions).
        pipe(map( user => {
            if (user && user.token) {
                console.log('post success');
                localStorage.setItem('currentUser', JSON.stringify(user));
                this.currentUserSubject.next(user);
                this.isLoggedIn = true;
            } else {
                this.isLoggedIn = false;
            }
            return user;
         }));
    }
    public isUserLoggedIn(): boolean {
        return this.isLoggedIn;
    }
    login(user: User) {

    }
    public logOut(){
        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(null);
        this.router.navigateByUrl('/');

    }
}

import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, from } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../model/User';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';

const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
@Injectable({providedIn: 'root'})
export class AuthenticationService {
  private isLoggedIn = false;
    private users: User[] = [
        new User('aelaf', 'ted'),
        new User('dave', 'deva')
       ];
    private currentUserSubject: BehaviorSubject<User>;
    public currentUser: Observable<User>;
    constructor(private http: HttpClient) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
    }
    public get currentUserValue(): User {
        return this.currentUserSubject.value;
    }
    public  isUserAuthentic(fName: string, lName: string): Observable<boolean> {

        return from([this.users]).pipe(map(data => {
            const user = data.find(d => (d.firstName === fName) && (d.lastName === lName));
            if (user) {
                this.isLoggedIn = true;
            } else {
                this.isLoggedIn = false;
            }
            return this.isLoggedIn;
        }));
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
            return this.isLoggedIn;
         }));
    }
    public isUserLoggedIn(): boolean {
        return this.isLoggedIn;
    }
    login(user: User) {

    }
}

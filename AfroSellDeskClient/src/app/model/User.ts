import { Injectable } from '@angular/core';
import { Role } from './Role';

@Injectable({
  providedIn: 'root'
})
export class User {
    id: number;
    firstName: string;
    lastName: string;
    userName: string;
    password: string;
    role: Role;
    token: string;
    constructor(firstName: string, lastName: string){
      this.firstName = firstName;
      this.lastName = lastName;
    }
}
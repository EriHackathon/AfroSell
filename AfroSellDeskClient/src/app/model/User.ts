import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class User {
    firstName: string;
    lastName: string;
    phone: string;
    country: string;
}
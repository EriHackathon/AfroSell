import { Component, OnInit } from '@angular/core';
import { FakeBackEnd } from 'src/app/helpers/fake-back-end';
import { User } from 'src/app/model/User';
import { Role } from 'src/app/model/Role';
import { BehaviorSubject } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})

export class WelcomeComponent implements OnInit {
  private currentUserSubject: BehaviorSubject<User>;
  constructor( private router: Router) { }

  ngOnInit() {
    this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
    if(this.currentUserSubject.value){
      console.log(this.currentUserSubject.value);
      console.log('got user');
      if(this.currentUserSubject.value.role === Role.Admin ) {
        console.log('got Admin');
        this.router.navigateByUrl('/admin');
      }else{
        console.log('got normal user');
        this.router.navigateByUrl('/home');
      }
    } else{
      console.log('... got nothing');
    }
    //get local storage
   // const user =  users.find(x => x.userName === request.body.userName && x.password === request.body.password);
  }

}

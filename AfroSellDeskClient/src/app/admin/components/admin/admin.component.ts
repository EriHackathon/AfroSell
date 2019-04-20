import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  userName: string;
  constructor(private auth: AuthenticationService, private router: Router) { }

  ngOnInit() {
    this.userName = this.auth.currentUserValue.firstName;
  }

 public  logOut() {
   this.auth.logOut();
  

 }
}

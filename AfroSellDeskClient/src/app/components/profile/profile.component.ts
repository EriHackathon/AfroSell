import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
userName: string;
  constructor(private auth: AuthenticationService) { }

  ngOnInit() {
    this.userName = this.auth.currentUserValue.firstName;
  }

}

import { Component, Input,OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { User } from 'src/app/model/User';

@Component({
  selector: 'app-afro-nav',
  templateUrl: './afro-nav.component.html',
  styleUrls: ['./afro-nav.component.css']
})
export class AfroNavComponent implements  OnInit{
 profile = 'Jack';
  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );

  constructor(private breakpointObserver: BreakpointObserver, private auth: AuthenticationService) {
    console.log(auth.currentUser);
  }

  ngOnInit() {
    this.profile =  this.auth.currentUserValue.firstName;

  }
logOut() {
 this.auth.logOut();

}

}

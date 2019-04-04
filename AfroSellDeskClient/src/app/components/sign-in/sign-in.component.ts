import { Component, OnInit } from '@angular/core';
import { Form, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { first } from 'rxjs/operators';
@Component({
  // selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
formSignIn: FormGroup;
private return = '';
  constructor(private auth: AuthenticationService, private formBuilder: FormBuilder, private router: Router,
              private route: ActivatedRoute, private ps: ProductService) {
    this.formSignIn = this.formBuilder.group({
      userName: [null, Validators.required],
      password: [null, Validators.required]
    });
  }

  ngOnInit() {
    this.route.queryParams
    .subscribe(x => {
    this.return = x.return || '/';
    this.ps.addEdit = true;
    console.log('going back' + this.return);
    this.router.navigateByUrl(this.return);
    // user is not logged in
    if ( !this.auth.isUserLoggedIn) {
      // do we really need this?!
    }
    });
  }

  onSignIn(): void {
    // authentication on
   this.auth.makeUserAuthentic(this.formSignIn.value).pipe(first()).subscribe(res => {
    if (res) {
      console.log('authentic...' + this.return);
      this.router.navigateByUrl(this.return);
    } else {
      this.formSignIn.setErrors({
        error: true
      });
    }
   });
   localStorage.setItem('afroUser', this.formSignIn.value.userName);
   console.log(this.formSignIn.value.userName);
  }

}

import { Component, OnInit } from '@angular/core';
import { Form, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';

@Component({
  // selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
formSignIn: FormGroup;
private return: string = '';
  constructor(private formBuilder: FormBuilder, private router: Router, private route: ActivatedRoute, private ps: ProductService) {
    this.formSignIn = this.formBuilder.group({
      userName: [null, Validators.required],
      password: [null, Validators.required]
    });
  }

  ngOnInit() {
    this.route.queryParams
    .subscribe(x => {
    this.return = x.return || '/signIn';
    this.ps.addEdit = true;
    console.log('going back' + this.return);
    this.router.navigateByUrl(this.return);
    });
  }

  onSignIn(): void {
    console.log(this.formSignIn.value);
  }
}

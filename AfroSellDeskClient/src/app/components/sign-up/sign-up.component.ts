import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { User } from 'src/app/model/User';

@Component({
   selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
formSignUp: FormGroup ;
  constructor(private user: User, private formBuilder: FormBuilder) {
    this.formSignUp = this.formBuilder.group({
      firstName: [null, Validators.required],
      lastName: [null, Validators.required],
      phone: [null, Validators.required],
      country: [null, Validators.required]
    });
  }

  ngOnInit() {
    console.log('wait... sing up ');
  }
 onSignUp(): void {

  console.log(this.formSignUp.value);
 }
}

import { Component, OnInit } from '@angular/core';
import { Form, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  // selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
formSignIn: FormGroup;
  constructor(private formBuilder: FormBuilder) {
    this.formSignIn = this.formBuilder.group({
      userName: [null, Validators.required],
      password: [null, Validators.required]
    });
  }

  ngOnInit() {
  }

  onSignIn(): void{
    console.log(this.formSignIn.value);
  }
}

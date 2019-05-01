import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  formSignUp: FormGroup ;
  constructor( private formBuilder: FormBuilder) {
    this.formSignUp = this.formBuilder.group({
      firstName: [null, Validators.required],
      lastName: [null, Validators.required],
      phone: [null, Validators.required],
      country: [null, Validators.required]
    });
  }

  ngOnInit() {
    console.log('register up...');
  }
  onSignUp(): void {

    console.log(this.formSignUp.value);
   }
}

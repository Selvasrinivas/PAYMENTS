import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserServiceService } from 'src/app/user-service.service';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})

export class UserRegisterComponent implements OnInit {

  signUpForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private userService: UserServiceService) { }

  ngOnInit() {
 
    this.signUpForm = this.formBuilder.group({
     
      firstName: ['', [
        Validators.required, Validators.minLength(2), Validators.maxLength(30)
      ]],
      lastName: ['', [
        Validators.required, Validators.minLength(2), Validators.maxLength(30)
      ]],
      gender: ['', [
        Validators.required, Validators.minLength(2), Validators.maxLength(30)
      ]],
      age: ['', [
        Validators.required, Validators.minLength(2), Validators.maxLength(30)
      ]],
      contactNumber: ['', [
        Validators.required, Validators.minLength(2), Validators.maxLength(30)
      ]],
      
      pan: ['', [
        Validators.required, Validators.minLength(2), Validators.maxLength(30)
      ]],
      aadhar: ['', [
        Validators.required, Validators.minLength(2), Validators.maxLength(30)
      ]],
      usId: ['', [
        Validators.required,
 
      ]],
      password: ['', [
        Validators.required, Validators.minLength(2), Validators.maxLength(30)
      ]],
     
    })

    
  }
 
  get firstname() {
    return this.signUpForm.get('firstname');
  }
  get lastname() {
    return this.signUpForm.get('lastname');
  }
  get gender() {
    return this.signUpForm.get('gender');
  }
  get age() {
    return this.signUpForm.get('age');
  }
  get contactNumber() {
    return this.signUpForm.get('contactNumber');
  }
 
  get pan() {
    return this.signUpForm.get('pan');
  }
  get aadhar() {
    return this.signUpForm.get('aadhar');
  }
  get usId() {
    return this.signUpForm.get('usId');
  }
  get password() {
    return this.signUpForm.get('password');
    
  }
}
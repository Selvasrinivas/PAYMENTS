import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserServiceService } from 'src/app/user-service.service';

@Component({
  selector: 'app-admin-register',
  templateUrl: './admin-register.component.html',
  styleUrls: ['./admin-register.component.css']
 })
// export class AdminRegisterComponent implements OnInit {
//    registerForm:FormGroup
//   // Gender:any =  ['Male', 'Female']
//   constructor( private router:Router,private formBuilder:FormBuilder) { }

//   ngOnInit() {
//   }
//   toVendor() {
//     this.router.navigate(['vendorregister'])
//   }
// }
export class AdminRegisterComponent implements OnInit {

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
 
  get firstName() {
    return this.signUpForm.get('firstName');
  }
  get lastName() {
    return this.signUpForm.get('lastName');
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
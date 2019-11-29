import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserServiceService } from 'src/app/user-service.service';
import { Vendor } from 'src/app/vendor';

@Component({
  selector: 'app-vendor-register',
  templateUrl: './vendor-register.component.html',
  styleUrls: ['./vendor-register.component.css']
})
// export class VendorRegisterComponent implements OnInit {

//   constructor() { }

//   ngOnInit() {
//   }
 

// }
export class VendorRegisterComponent implements OnInit {

  vendors = ["Electricity", "Telephone", "DTH", "Insurance", "Tax", "Credit Card", "Loan Account", "Others"]
  addressList = ["Guntur", "Vijayawada", "Hyderabad", "Secunderabad", "Sanya", "Dongfang", "Jinan", "Zibo"]
  stateList = ["Andhra Pradesh", "Telangana", "Hainan", "Shandong"]
  countryList = ["India", "China"]
  saved: boolean = false;
  vendorDetails: Vendor;
  registrationFormV: FormGroup;
  constructor(private formBuild: FormBuilder, private router: Router, private userService: UserServiceService) { }

  ngOnInit() {
    this.registrationFormV = this.formBuild.group({
      name: [null, [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(20)
      ]],
      companyRegNo: [null, [
        Validators.required
      ]],
      type: [null, [
        Validators.required
      ]],
      address: [null, [
        Validators.required
      ]],
      country: [null, [
        Validators.required
      ]],
      state: [null, [
        Validators.required
      ]],
      email: [null, [
        Validators.required
      ]],
      contact: [null, [
        Validators.required,
        Validators.minLength(10),
        Validators.maxLength(10)
      ]],
      website: [null, [
        Validators.required
      ]],
      certificateIssue: [null, [
        Validators.required
      ]],
      certificateValidity: [null, [
        Validators.required
      ]],
      yearEstablish: [null, [
        Validators.required
      ]],
      payment: [null, [
        Validators.required
      ]]
    })
  }

  get name() {
    return this.registrationFormV.get('name');
  }
  get companyRegNo() {
    return this.registrationFormV.get('companyRegNo');
  }
  get type() {
    return this.registrationFormV.get('type');
  }
  get address() {
    return this.registrationFormV.get('address');
  }
  get country() {
    return this.registrationFormV.get('country');
  }
  get state() {
    return this.registrationFormV.get('state');
  }
  get email() {
    return this.registrationFormV.get('email');
  }
  get contact() {
    return this.registrationFormV.get('contact');
  }
  get website() {
    return this.registrationFormV.get('website');
  }
  get certificateIssue() {
    return this.registrationFormV.get('certificateIssue');
  }
  get certificateValidity() {
    return this.registrationFormV.get('certificateValidity');
  }
  get yearEstablish() {
    return this.registrationFormV.get('yearEstablish');
  }
 
  onSubmit() {
    let newVendor: Vendor = {
      //  id:this.userDetails.id,
      vendorId: 0,
      name: this.registrationFormV.value["name"],
      companyRegNo: this.registrationFormV.value["companyRegNo"],
      type: this.registrationFormV.value["type"],
      address: this.registrationFormV.value["address"],
      country: this.registrationFormV.value["country"],
      state: this.registrationFormV.value["state"],
      email: this.registrationFormV.value["email"],
      contact: this.registrationFormV.value["contact"],
      website: this.registrationFormV.value["website"],
      certificateIssue: this.registrationFormV.value["certificateIssue"],
      certificateValidity: this.registrationFormV.value["certificateValidity"],
      yearEstablish: this.registrationFormV.value["yearEstablish"],

     
   
    }
    alert("dhbs"+this.registrationFormV.value["name"]),

    alert(JSON.stringify(newVendor))
    this.userService.saveVendor(newVendor).subscribe(
      (data) => {
        this.saved = true;
        // this.foodservice.updateFoodItem(newItem);
        this.router.navigate(['home'])
      }
    )
  }

}


import { Component, OnInit } from '@angular/core';
import { UserServiceService } from 'src/app/user-service.service';
import { User } from 'src/app/user';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import {  bill } from 'src/app/bill';
import { Router } from '@angular/router';

@Component({
  selector: 'app-credit-card',
  templateUrl: './credit-card.component.html',
  styleUrls: ['./credit-card.component.css']
})
export class CreditCardComponent implements OnInit {
userId:number;
editForm: FormGroup;

  constructor(private userService:UserServiceService,private formBuild:FormBuilder,private router:Router) { }
id:number=2;
type:number=6;
no:number;
  ngOnInit() {



    
  //   let vendorEdit : bill={
  // billId:0,
  // amount:0,
  //   }

    this.userService.getbill(this.id,this.type).subscribe(
      (data) => {
        
    this.no=data;
      alert(this.no);
        alert(JSON.stringify(data))
    
      
      }
    );
    
  }

  onSubmit() {
    this.router.navigate(['paybill']);
  }


}

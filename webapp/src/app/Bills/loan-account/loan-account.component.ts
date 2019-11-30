import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { UserServiceService } from 'src/app/user-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loan-account',
  templateUrl: './loan-account.component.html',
  styleUrls: ['./loan-account.component.css']
})
export class LoanAccountComponent implements OnInit {

  userId:number;
  editForm: FormGroup;
  
    constructor(private userService:UserServiceService,private formBuild:FormBuilder,private router:Router) { }
  id:number=2;
  type:number=7;
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
      this.router.navigate(['paybill'])
    }
  
  
  }
  
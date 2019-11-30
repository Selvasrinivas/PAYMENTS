import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { UserServiceService } from 'src/app/user-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tax',
  templateUrl: './tax.component.html',
  styleUrls: ['./tax.component.css']
})
export class TaxComponent implements OnInit {
  userId:number;
  editForm: FormGroup;
  
    constructor(private userService:UserServiceService,private formBuild:FormBuilder,private router:Router) { }
  id:number=2;
  type:number=5;
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
  
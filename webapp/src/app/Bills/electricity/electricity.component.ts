import { Component, OnInit } from '@angular/core';
import { UserServiceService } from 'src/app/user-service.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-electricity',
  templateUrl: './electricity.component.html',
  styleUrls: ['./electricity.component.css']
})
export class ElectricityComponent implements OnInit {
  userId:number;
  editForm: FormGroup;
  
    constructor(private userService:UserServiceService,private formBuild:FormBuilder,private router:Router) { }
  id:number=2;
  type:number=1;
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
  
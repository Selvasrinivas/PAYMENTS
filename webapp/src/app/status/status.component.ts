import { Component, OnInit } from '@angular/core';
import { Vendor } from '../vendor';
import { UserServiceService } from '../user-service.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-status',
  templateUrl: './status.component.html',
  styleUrls: ['./status.component.css']
})
export class StatusComponent implements OnInit {

item:any;
  constructor(private userservice : UserServiceService) { }
Vendor:Vendor;

  getAllVendors():Vendor[] {
    this.userservice.getVendor().subscribe((Vendor)=>this.item=Vendor)
    alert(JSON.stringify(this.Vendor));
    return this.item;
  }
  ngOnInit()  {
    this.userservice.getVendor().subscribe((data)=>{
      alert(JSON.stringify(this.item))
      this.item=data;
    });
    
    //this.Vendors=Vendor)
  //  this.getAllVendors().subscribe(
  //   (item)=>{this.Vendors=this.Vendor},
  //   (error: HttpErrorResponse) => {
  //     this.Vendors = error;
  //     if (error instanceof Error) {
  //      alert("client side error" + error.message);
  //     } else {
  //      alert("server side error" + error.message);
  //     }
  //   }
   
  // ); 

  }
  Accept()
  {
    alert("Accepted Successfully");
  }
  Remarks()
  {
    alert("Sent For Correction");
  }
  Delete(id){
    alert(id);
    this.userservice.deletevendor(id).subscribe(
     
      )
  }
}
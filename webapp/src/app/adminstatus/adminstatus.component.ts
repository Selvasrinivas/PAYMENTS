import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-adminstatus',
  templateUrl: './adminstatus.component.html',
  styleUrls: ['./adminstatus.component.css']
})
export class AdminstatusComponent implements OnInit {
  item:any;
  constructor(private router:Router,private userservice : UserServiceService) { }

  ngOnInit() {
    this.userservice.getVendor().subscribe((data)=>{
      alert(JSON.stringify(this.item))
      this.item=data;
    });
  }
Register()
{
  this.router.navigate(['vendorregister']);
}

}

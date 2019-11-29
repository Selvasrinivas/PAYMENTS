import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private router:Router,private userService: UserServiceService) { }

  ngOnInit() {
  }
  toAdmin() {
    this.userService.userRoleBoo=true;
    this.router.navigate(['adminregister'])
  }
  toCustomer() {
    this.userService.userRoleBoo=false;
    this.router.navigate(['userregister'])
  }

}

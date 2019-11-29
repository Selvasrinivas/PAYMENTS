import { Component } from '@angular/core';
import { AuthServiceService } from './auth-service.service';
import { Router } from '@angular/router';
import { BillserviceService } from './Services/billservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Bill-Payment-System';
  isLoggedIn:boolean = false;
  isAd:boolean=false;
  ngOnInit(): void {
    this.loggedIn();
    this.Ad();
    // this.router.navigate(['search']);
  }
  constructor(private authService:AuthServiceService,public router: Router,private billService:BillserviceService){}
  loggedIn():boolean {
    if(!this.authService.loggedInUser.loggedOut){
      this.isLoggedIn = true;
      return true
    }
    else{
      this.isLoggedIn = false;
      return false;
    }

}
Ad():Boolean{
  if(this.billService.isAdmin=true)
  {
this.isAd=true;
return true;
  }
  else{
    this.isAd = false;
    return false;
  }
}
}

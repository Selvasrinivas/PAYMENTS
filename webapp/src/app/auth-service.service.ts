import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { BillserviceService } from './Services/billservice.service';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  loggedInUser={loggedOut:true};
  validCredentials:boolean = true;
  accessToken: string; // JWT token
  redirectUrl = '/';
  loggedIn:boolean = false;
  name:string;
  username:string;
  role: string="";
 
 
  constructor(private _httpClient:HttpClient,public router: Router,private billService:BillserviceService) { }
  private authenticationApiUrl:string=environment.authbaseUrl;
  token: string="";
  authenticate(user: string, password: string): Observable<any> {

    var up=user+":"+password;
    var credentials=btoa(user + ':' + password);
    alert("it has come to authenticate");
    alert(credentials+"-----credentialsssssss");
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic ' + credentials);
   alert(JSON.stringify(headers)+"----headers");
    return this._httpClient.get(this.authenticationApiUrl, {headers});
  
  }
  authenticateUser(user) {
    

alert("i am in authenticateUser");
    this.authenticate(user.username,user.password).subscribe((item) => { 
  

       this.setToken(item.token);
       this.setRole(item.role);
       localStorage.setItem('token',item.token);
       localStorage.setItem('role',item.role);
    
       this.loggedInUser = user;
       this.validCredentials = true;
       
        if(this.getRole() === 'ROLE_ADMIN') {
          this.router.navigate(['adminstatus']);
          this.loggedIn = true;
          this.billService.isAdmin = true;
        }
        if(this.getRole()=== 'ROLE_USER') 
        {
          this.router.navigate(['userbill']);
          this.loggedIn = true;
          this.billService.isUser=true;

        }
        if(this.getRole()=== 'ROLE_SUPER') 
        {
          this.router.navigate(['status']);
          this.loggedIn = true;
          this.billService.isUser=true;

        }
        
       
      
     this.billService.isLoggedIn = true;
      // this.name = this.userService.getUser(user.username).lastname.concat(".").concat(this.userService.getUser(user.username).firstname);
       this.username=user.username;

  
   },(error: HttpErrorResponse) => {
     this.validCredentials = false;
    // alert("error" + error.message);
     this.router.navigate(['login']);
   }
    );
 
}

logout() {
  this.loggedInUser = {loggedOut:true};
 // this.foodService.isAdmin = false;
  this.loggedIn = false;
 // this.foodService.isLoggedIn = false;
 /// this.foodService.clickedOnAdd = false;
 // this.foodService.addedToCart = false;
  localStorage.removeItem('token')
  //alert("venu askedddddd------"+localStorage.getItem('token'))
  this.router.navigate(['login']);
  // this.router.navigate(['search-bar']);
}

public setToken(token: string) {
  this.token = token;
}
public getToken() {
  return this.token;
}
public setRole(role: string) {
  this.role = role;
}
public getRole() {
  return this.role;
}
}

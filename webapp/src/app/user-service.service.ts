import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { User } from '../app/user';
import { Router } from '@angular/router';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vendor } from './vendor';
@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
 
  userName:User;
useradded:boolean;
msg:string=null;
userurl:string=environment.userUrl;
vendorurl:string=environment.vendorUrl;
billurl:string=environment.billUrl;

i:number;
userRole:string;
private token:string = "";
userRoleBoo:boolean;
acceptVendor : boolean = false;
// useradded: boolean;
usern: String;
userExists: boolean = true;

public setToken(token: string) {
  this.token = token;
}
public getToken() {
  return this.token;
}






  constructor(private router:Router,private _httpClient:HttpClient) { }

  addNewUser(newUser: User): Observable<any> {
    
    // let headers = new HttpHeaders();
    // console.log(this.menuItemService.getToken());
    // headers = headers.set('Authorization', 'Bearer '+this.menuItemService.getToken());
    alert(newUser.usId + ",,,,,username")
    this.usern = newUser.usId
 //   alert("url......." + this.userurl+"/"+this.userRoleBoo)
    alert("NEW USER      "+JSON.stringify(newUser));
    if(this.userRoleBoo==false)
    {
      this.i=2;
    }
    else{
      this.i=1;
    }
    alert("url......." + this.userurl+"/"+this.i)
    return this._httpClient.post<any>(this.userurl+"/"+this.i, newUser);   //,{headers}
  }

  addUser(user: User) 
  {
    //this.userList.push(user);
    alert("my new user:::: " + JSON.stringify(user));

    this.addNewUser(user).subscribe((res) => 
    {

      alert("this.useradded=res" + user);
   //   this.useradded = res;
     // alert("this.useradded=res" + res);

    },
      (error: HttpErrorResponse) => {
        //this.employeeList=error;

        this.router.navigate(['login']);
        alert("error in authenticate" + error.message);
        if (error instanceof Error) {
          alert("errrrr cllient" + error.message)
        } else {
          alert("server side" + error.message);
        }
      }
    )

    this.router.navigate(['login']);
  }
    saveVendor(vendor: Vendor) :  Observable<any>{
      alert(JSON.stringify
        (vendor));
    let headers=new HttpHeaders();
    headers =headers.set('Authorization',  'Bearer' +this.getToken());
    return this._httpClient.post<any>(this.vendorurl,vendor,{headers});
  }
  public getVendor(): Observable <any>
  {
    let headers=new HttpHeaders();
    headers =headers.set('Authorization',  'Bearer' +this.getToken());
    return this._httpClient.get<any>(this.vendorurl,{headers});
  }
  public getVById(id):Observable<any>
  {
    let headers=new HttpHeaders();
    headers =headers.set('Authorization',  'Bearer' +this.getToken());
    return this._httpClient.get<any>(this.vendorurl+"/"+id,{headers});
  }
  public deletevendor(id:number): Observable <any>
  {
    let headers=new HttpHeaders();
    headers =headers.set('Authorization',  'Bearer' +this.getToken());
    return this._httpClient.delete<any>(this.vendorurl+"/"+id,{headers});
  }
  public  getbill(id:number,type:number)
  {
    let headers=new HttpHeaders();
    headers =headers.set('Authorization',  'Bearer' +this.getToken());
    alert(this.billurl+"/"+id+"/"+type);
    return this._httpClient.get<any>(this.billurl+"/"+id+"/"+type,{headers});
  }
}



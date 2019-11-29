import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup

  constructor(private router:Router, private formBuild:FormBuilder) { }

  ngOnInit() {
    this.loginForm = this.formBuild.group({
      username: ['',[
        Validators.required
      ]],
      password: ['',[
        Validators.required
      ]]
    })

    
  }
  get username(){
    return this.loginForm.get('username');
  }
  get password(){
    return this.loginForm.get('password');
  }

  
  
  toSignup() {
    this.router.navigate(['register'])
  }
  onSubmit(loginvalue)
  {
    //alert("gjhgjgfj"+JSON.stringify(loginvalue))
    const username = loginvalue.username;
    const password = loginvalue.password;
   // alert(username+","+password)
    if(username=== "u" && password==="u"){
      this.router.navigate(['userbill'])
    }else if(username=== "a" && password==="a"){
      this.router.navigate(['vendorregister'])
    }else if(username=== "v" && password==="v"){
      this.router.navigate(['vendorregister'])
    }else{
      alert("invalid user")
      
    }
  }

}

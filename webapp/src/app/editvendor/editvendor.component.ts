import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserServiceService } from '../user-service.service';
import { DatePipe } from '@angular/common';
import { Vendor } from '../vendor';
import { User } from '../user';

@Component({
  selector: 'app-editvendor',
  templateUrl: './editvendor.component.html',
  styleUrls: ['./editvendor.component.css']
})
export class EditvendorComponent implements OnInit {
  vendors = ["Electricity","Telephone","DTH","Insurance","Tax","Credit Card","Loan Account","Others"]
  addressList = ["Guntur","Vijayawada","Hyderabad","Secunderabad","Sanya","Dongfang","Jinan","Zibo"]
  stateList = ["Andhra Pradesh","Telangana","Hainan","Shandong"]
  countryList = ["India","China","Chile"]
  vendorDetails : Vendor;
  editForm: FormGroup;
  saved:boolean = false;
  itemUpdated = false;


  vendorId : number;
  name : string;
  companyRegNo : string;
  type : string;
  address:string;
  country : string;
  state: string;
  email : string;
  contact : string;
  website : string;
  certificateIssue:Date;
  certificateValidity:Date;
  yearEstablish:number;
  
  constructor(private router:ActivatedRoute,private rout:Router,private formBuild:FormBuilder, private userService:UserServiceService,
     private datepipe:DatePipe) { }
id:any;
  ngOnInit() {
    this.id=this.router.snapshot.paramMap.get('vendorId');
    alert(this.id)

    let vendorEdit : Vendor={
      vendorId : null,
name : null,
companyRegNo : null,
type : null,
address : null,
country : null,
state : null,
email : null,
contact : null,
website : null,
certificateIssue : null,
certificateValidity : null,
yearEstablish : null,

}


    this.userService.getVById(this.id).subscribe(
      (data) => {
        //data.dateOfLaunch = new Date(data.dateOfLaunch);
        vendorEdit = data;
        alert(JSON.stringify(data))
        // this.foodItem.dateOfLaunch.setDate(this.foodItem.dateOfLaunch.getDate()+1);
        let issueDate1 =this.datepipe.transform(vendorEdit.certificateIssue, 'yyyy-MM-dd');
        let validityDate1 =this.datepipe.transform(vendorEdit.certificateValidity, 'yyyy-MM-dd');
    
        this.editForm = this.formBuild.group({
          name: [vendorEdit.name,[
            Validators.required,
            Validators.minLength(2),
            Validators.maxLength(20)
          ]],
          companyRegNo: [vendorEdit.companyRegNo,[
            Validators.required
          ]],
          type: [vendorEdit.type,[
            Validators.required
          ]],
          address: [vendorEdit.address,[    //dateOfLaunch.toISOString().substring(0,10)
            Validators.required
          ]],
          country: [vendorEdit.country,[
            Validators.required
          ]],
          state: [vendorEdit.state,[
            Validators.required
          ]],
          email: [vendorEdit.email,[
            Validators.required
          ]],
          contact: [vendorEdit.contact,[
            Validators.required
          ]],
          website: [vendorEdit.website,[
           
          ]],
          certificateIssue: [issueDate1,[
            Validators.required
          ]],
          certificateValidity: [validityDate1,[
            Validators.required
          ]],
          yearEstablish: [vendorEdit.yearEstablish,[
            Validators.required
          ]],

        })
      }
    );
    }
    onSubmit()
     {
      let newVendor:Vendor = {
      //  id:this.userDetails.id,
        vendorId:this.id,
        name:this.editForm.value["name"],
        companyRegNo:this.editForm.value["companyRegNo"],
        type:this.editForm.value["type"],
        address:this.editForm.value["address"],
        country:this.editForm.value["country"],
        state:this.editForm.value["state"],
        email:this.editForm.value["email"],
        contact:this.editForm.value["contact"],
        website:this.editForm.value["website"],
        certificateIssue:this.editForm.value["certificateIssue"],
        certificateValidity:this.editForm.value["certificateValidity"],
        yearEstablish:this.editForm.value["yearEstablish"],
      
      }
      alert(JSON.stringify(newVendor))
      this.userService.saveVendor(newVendor).subscribe(
        (data) => {
          this.saved = true;
          // this.foodservice.updateFoodItem(newItem);
          alert("Details Saved Successfully...")
          this.rout.navigate(['home'])
        }
      )
    }




  }



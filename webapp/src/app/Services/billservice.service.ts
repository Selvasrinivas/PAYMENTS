import { Injectable } from '@angular/core';
import { Subject} from 'rxjs';
import { bill } from '../bill/bill';

@Injectable({
  providedIn: 'root'
})
export class BillserviceService {
  private subject = new Subject<bill[]>();
  isAdmin:boolean = false;
  isUser:boolean = false;

  isLoggedIn:boolean = false;
  clickedOnAdd:boolean = false;
  items:any;
  
  constructor() { }
  // getSubject(): Subject<bill[]> {
  //   return this.subject;
  // }
}

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HelpComponent } from './help/help.component';
import { AdminRegisterComponent } from './RegisterForm/admin-register/admin-register.component';
import { UserRegisterComponent } from './RegisterForm/user-register/user-register.component';
import { SearchComponent } from './frontpage/search/search.component';
import { UserbillComponent } from './userbill/userbill.component';
import { ElectricityComponent } from './Bills/electricity/electricity.component';
import { TelephoneComponent } from './Bills/telephone/telephone.component';
import { LoanAccountComponent } from './Bills/loan-account/loan-account.component';
import { InsuranceComponent } from './Bills/insurance/insurance.component';
import { TaxComponent } from './Bills/tax/tax.component';
import { DTHComponent } from './Bills/dth/dth.component';
import { CreditCardComponent } from './Bills/credit-card/credit-card.component';
import { OthersComponent } from './Bills/others/others.component';
import { VendorRegisterComponent } from './RegisterForm/vendor-register/vendor-register.component';
import { AppComponent } from './app.component';
import { StatusComponent } from './status/status.component';
import { AdminstatusComponent } from './adminstatus/adminstatus.component';
import { EditvendorComponent } from './editvendor/editvendor.component';
import { PaymentComponent } from './payment/payment.component';


const routes: Routes = [
  { path: 'login',component: LoginComponent},
  {path: 'home',component:AppComponent},
  { path: 'register',component: RegisterComponent},
  { path: 'help',component: HelpComponent},
  { path: 'adminregister',component: AdminRegisterComponent},
  { path: 'userregister',component: UserRegisterComponent},
  { path: 'vendorregister',component: VendorRegisterComponent},
  { path: 'search',component: SearchComponent},
  { path: 'userbill',component: UserbillComponent},
  { path: 'electricity',component: ElectricityComponent},
  { path: 'telephone',component: TelephoneComponent},
  { path: 'insurance',component: InsuranceComponent},
  { path: 'tax',component: TaxComponent},
  { path: 'loan',component: LoanAccountComponent},
  { path: 'dth',component: DTHComponent},
  { path: 'credit',component: CreditCardComponent},
  {path:   'status', component:StatusComponent},
  { path: 'other',component: OthersComponent},
  {path: 'adminstatus',component:AdminstatusComponent},
  {path: 'editvendor/:vendorId',component:EditvendorComponent},
  {path:'paybill',component:PaymentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

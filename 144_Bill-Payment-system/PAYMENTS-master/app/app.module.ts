import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HelpComponent } from './help/help.component';
import { AdminRegisterComponent } from './RegisterForm/admin-register/admin-register.component';
import { UserRegisterComponent } from './RegisterForm/user-register/user-register.component';
import { SearchComponent } from './frontpage/search/search.component';
import { UserbillComponent } from './userbill/userbill.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ElectricityComponent } from './Bills/electricity/electricity.component';
import { TelephoneComponent } from './Bills/telephone/telephone.component';
import { DTHComponent } from './Bills/dth/dth.component';
import { InsuranceComponent } from './Bills/insurance/insurance.component';
import { TaxComponent } from './Bills/tax/tax.component';
import { CreditCardComponent } from './Bills/credit-card/credit-card.component';
import { LoanAccountComponent } from './Bills/loan-account/loan-account.component';
import { OthersComponent } from './Bills/others/others.component';
import { VendorRegisterComponent } from './RegisterForm/vendor-register/vendor-register.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HelpComponent,
    AdminRegisterComponent,
    UserRegisterComponent,
    SearchComponent,
    UserbillComponent,
    ElectricityComponent,
    TelephoneComponent,
    DTHComponent,
    InsuranceComponent,
    TaxComponent,
    CreditCardComponent,
    LoanAccountComponent,
    OthersComponent,
    VendorRegisterComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

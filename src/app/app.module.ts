import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';



import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import {FormsModule}  from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { SharedModule } from './shared/shared.module';
import { CoreModule } from './core/core.module';
import {LayoutModule } from './layout/layout.module';
import { ManageCustomerModule } from './layout/manage-customer/manage-customer.module';
import { ManageUserModule } from './layout/manage-user/manage-user.module';

import { TestComponent } from './components/test/test.component';
import { HomeComponent } from './components/home/home.component';
import { CustomerComponent } from './components/customer/customer.component';


const routes: Routes = [
    { path: '', component: HomeComponent   },
    { path: 'home', component: HomeComponent   },
    { path: 'test', component: TestComponent  },
    { path: 'customer', component: CustomerComponent  },
     { path: '**', redirectTo: 'test' }//,
   // { path: 'test' , component: TestComponent },
   // { path: 'createCustomer' , component: CreateCustomerComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    TestComponent,
    HomeComponent,
    CustomerComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

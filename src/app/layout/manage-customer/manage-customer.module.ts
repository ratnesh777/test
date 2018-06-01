import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ManageCustomerComponent } from './manage-customer.component';
import { CreateCustomerComponent } from './create-customer.component';


@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [CreateCustomerComponent, ManageCustomerComponent]
})
export class ManageCustomerModule { }

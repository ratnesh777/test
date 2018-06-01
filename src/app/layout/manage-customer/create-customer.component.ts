import { Component, OnInit,ViewChild } from '@angular/core';
import {NgForm} from '@angular/forms';


@Component({
  selector: 'app-create-customer',
  templateUrl: 'create-customer.component.html'
})

export class CreateCustomerComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  
  	customerName:string = '';
  	customerCreated = false;
  	customerCreationStatus:string = 'No customer was created!';

	customer ={
		custName : '',
		emailDomain : '',
		siteID : '',
		softClientURL : '',
		ntrServerFQDN : '',
		skypeURL : '',
		isUsingADFS : ''
	};
	
	
	
	createCustomer(){
		console.log("save");
	 	//this.customerCreated = true;
	 	this.customerCreationStatus ='Customer was created, Name is ' + this.customerName + '.';
    	this.customerName='';
    	// console.log(form);
    		  
		  
	}
    
  /* onSubmit(form: HTMLFormElement){
    	  console.log("Submitted");
      	  console.log(form);
    }  */
    
   @ViewChild('createCustomerForm') customerForm : NgForm;
   
     onSubmit(form: NgForm){
    	  console.log("Submitted :: " + form);
      	  console.log(this.customerForm);
      	 this.customerCreated = true;
      	  this.customer.custName = this.customerForm.value.custName;
      	  this.customer.emailDomain = this.customerForm.value.emailDomain;
      	  this.customerForm.reset();
      	  console.log("Updated");
    } 
}

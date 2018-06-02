import { Component, OnInit } from '@angular/core';
import {ManageCustomerService} from './manage-customer.service';

@Component({
    selector: 'app-customer',
    templateUrl: './customer.component.html',
    styleUrls: ['./customer.component.css'],
    providers: [ManageCustomerService]
})

export class CustomerComponent implements OnInit {

    private apiDataUrl: string = "http://localhost:8443/api/customer";
    constructor(public customerService: ManageCustomerService) { }

    //customers = [];
    public customers;

    ngOnInit() {
        // const customerService = new ManageCustomerService()
        this.customers = this.getCustomers();
       // this.getCustomersUpdated();
       // this.customers = this.getCustomersUpdated();
        console.log("done ngOnInit");
    }

    getCustomers() {
        this.customerService.getCustomers(this.apiDataUrl).subscribe(
            data => { this.customers = data },
            err => console.error(err),
             () => console.log('done loading customers')
        );
     
    }

    getCustomersUpdated() {
        return  this.customerService.getCustomersUpdated(this.apiDataUrl);
    }

     /* getCustomerUsingObservables():Observable<any[]>{
       //return this._httpprovider.httpReq('http://192.168.1.40:5000/getmapmasterstore','GET',null,null).map(res =>{<any[]>res.json()}
    }*/
    
}

import { Injectable } from '@angular/core';
//import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class ManageCustomerService {

    constructor(public http:HttpClient) { }

    
    getCustomers(url: string) {
        console.log("Inside service");
        //this.http.get(url).subscribe(res => console.log(res.json()));

        console.log("exiting service");
        return this.http.get(url);
    }

    getCustomersUpdated(url: string) {
        console.log("Inside service");
        this.http.get(url).subscribe(
            data => data,
            err => console.error(err),
            () => console.log('done loading customers')
        );

        console.log("exiting service");
    }
    
    createCustomer(url:string, data){
        
      console.log('inside create customer' + data.name + " "+ data.emailDomain);
        
       return  this.http.post(url,data);
        /* this.http.post(url).subscribe(
             data => data,
            err => console.error(err),
            () => console.log('done loading customers')
          );*/
        
        }


}

/*export interface PageStatus {
  loading: boolean;
  error: boolean;
  success: boolean;
}*/
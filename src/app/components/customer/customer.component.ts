import { Component, OnInit } from '@angular/core';
import {ManageCustomerService} from './manage-customer.service';
import {GridOptions} from "ag-grid";
import { HttpClient, HttpHeaders } from '@angular/common/http';
//import { CustomHeader } from "../../components/grid/grid.custom-header.component";

@Component({
    selector: 'app-customer',
    templateUrl: './customer.component.html',
    styleUrls: ['./customer.component.css'],
    providers: [ManageCustomerService]
})

export class CustomerComponent implements OnInit {

    private apiDataUrl: string = "http://localhost:8443/api/customer";

    private gridOptions: GridOptions = {

    };
    //customers = [];
    public customers;

    constructor(public customerService: ManageCustomerService,  public http:HttpClient)  {
        console.log("inside constructor");
        this.gridOptions = <GridOptions>{
          //   columnDefs: CustomerComponent.getColumnDefs(),
           //  rowData: CustomerComponent.getStaticCustomers(),
            //rowData: this.customers,
            /* context: {
                componentParent: this
            },*/
        };

        //this.gridOptions.columnDefs = CustomerComponent.getColumnDefs;
        // this.gridOptions.frameworkComponents = { agColumnHeader: CustomHeader };
    }



    ngOnInit() {
        console.log("inside ngOnInit");
        // const customerService = new ManageCustomerService()
        this.customers = this.getCustomers();
         /*this.http.get(this.apiDataUrl).subscribe(
                    (response:any) => {
                        this.gridOptions.rowData = response.json();
                        
                    }
                );*/
       this.gridOptions.columnDefs = CustomerComponent.getColumnDefs(),
       this.http.get<any>(this.apiDataUrl).subscribe(
                  data => { this.gridOptions.rowData = data },
                err => console.error(err),
                () => console.log('done loading customers')
               ); 
        console.log("done ngOnInit");
        
        
    }

    getCustomers() {
        this.customerService.getCustomers(this.apiDataUrl).subscribe(
            data => { this.customers = data 
            },
            err => console.error(err),
            () => console.log('done loading customers')
        );

    }


    /*getCustomersUpdated() {
        return this.customerService.getCustomersUpdated(this.apiDataUrl);
    }*/

    private static getColumnDefs() {
        return [
            {
                width: 20,
                headerCheckboxSelection: true,
                headerCheckboxSelectionFilteredOnly: true,
                checkboxSelection: true,
                suppressMenu: true,
                minWidth: 40
            },

            {
                headerName: 'Id',
                field: 'id',
                suppressMenu: true


            },
            {
                headerName: 'Name',
                field: 'name',
                suppressMenu: true

            }
        ];
    }

    private static getStaticCustomers() {
        return  [
            {
                id: '1',
                name: 'BOA'

            },
            {
                id: '2',
                name: 'JPMC'

            }];
    }


}

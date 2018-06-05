import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-grid',
  templateUrl: './grid.component.html',
  styleUrls: ['./grid.component.css']
})
export class GridComponent implements OnInit {

    private params; any;
  constructor() { }

  ngOnInit() {
  }
    
    agInit(params : any) :void{
        
                this.params= params;
        } 

}

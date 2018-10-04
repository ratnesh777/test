import { Directive, ElementRef, OnInit } from "@angular/core";

@Directive({
    selector : '[appTestDirective]'
})
export class TestDirective implements OnInit{
    constructor(private elementRef:ElementRef){
        elementRef

    }

    ngOnInit(){
        this.elementRef.nativeElement.style.backgroundColor = 'green';
    }
}
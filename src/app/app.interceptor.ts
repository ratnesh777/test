import { Injectable } from '@angular/core';
import {HttpInterceptor, HttpRequest,HttpEvent, HttpHandler, HttpSentEvent, HttpHeaderResponse, HttpProgressEvent,
  HttpResponse, HttpUserEvent, HttpErrorResponse} from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { Router } from '@angular/router';
//import {TokenStorage} from './token.storage';


const JWT_TOKEN_HEADER_NAME = 'IPC-JWT';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

  
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let authReq = request;
        console.log("Interceptor ::" + request);
        //authReq = req.clone({ headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + this .token.getToken())});
         return next.handle(request);
    }
    //constructor(private token: TokenStorage, private router: Router) { }

  /*intercept(req: HttpRequest, next: HttpHandler):
    Observable | HttpUserEvent> {
    let authReq = req;
    if (this.token.getToken() != null) {
      authReq = req.clone({ headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + this .token.getToken())});
    }
    return next.handle(authReq).do(
        (err: any) => {
          if (err instanceof HttpErrorResponse) {
           
            if (err.status === 401) {
              this.router.navigate(['user']);
            }
          }
        }
      );
  }*/

}
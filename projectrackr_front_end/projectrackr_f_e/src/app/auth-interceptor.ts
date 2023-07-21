import { Injectable } from "@angular/core";
import { HttpInterceptor,HttpRequest,HttpHandler,HttpEvent } from "@angular/common/http";
import { Observable } from "rxjs";
import { TokenStorageService } from "./service/auth-storage.service";


@Injectable()
export class AuthInterceptor implements HttpInterceptor {
    constructor(private token :TokenStorageService){}
    
    
    
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        
        
        const jwtToken = this.token.getToken();

        if (!req.url.startsWith('http://localhost:8080/auth') && jwtToken != null){
            req = req.clone({
                headers:req.headers.set('Authorization',`Bearer ${jwtToken}`)
                
            });
            console.log(req);
        }


        return next.handle(req);

    }


}
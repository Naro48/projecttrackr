import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
    email: string = "";
    password:string = "";

    constructor(private http: HttpClient,private router: Router){}

    onSubmit(){
      const apiUrl = "https://localhost:8080/"
      const endpoint = '${apiUrl}/auth/authentication'
    

      const data = {
        email: this.email,
        password: this.password
      };

      this.http.post(endpoint,data).subscribe(
        (response:any) => {
          const token = response.token;

          localStorage.setItem('jwtToken',token);
          this.router.navigate(['/dashboard']);
        },
        (error) => {
          console.error("Erreur lors de l\'authentification",error);
        }
      )

    }




  }

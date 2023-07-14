import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AppConfig } from '../config';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
    firstname: string ="";
    lastname: string ="";
    dateOfBirth: string ="";
    email:string = "";
    gender:string= "";
    profil: string ="";
    role:string="";
    password:string= "";

    constructor(private http : HttpClient,private router: Router){}


    onSubmit(){
      
      const Url = AppConfig.apiUrl;

      const endpoint = '${Url}/auth/register'


      const formData = {
        firstname: this.firstname,
        lastname: this.lastname,
        email: this.email,
        password: this.password,
        role: this.role,
      }
      
      this.http.post(endpoint,formData).subscribe(
        (response:any) => {
          const registrationToken = response.token;

          localStorage.setItem("RegistrationToken", registrationToken);
          this.router.navigate(['/dashboard']);
        },
        (error) => {
          console.error("Erreur lors de l'Inscription")
        }
      )
      
      //reinitialisation des parametres
      this.firstname="";
      this.lastname="";
      this.dateOfBirth="";
      this.email="";
      this.gender="";
      this.profil="";
      this.role="";
    }
}

import { Component } from '@angular/core';
import { faAdd } from '@fortawesome/free-solid-svg-icons';
import { NgModel } from '@angular/forms';
import { ProjectService } from '../service/project.service';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Component({
  selector: 'app-create-project',
  templateUrl: './create-project-form.component.html',
  styleUrls: ['./create-project-form.component.scss']
})
export class CreateProjectFormComponent{
  faAdd = faAdd; 

  title : string = "" ; 
  date_debut: Date = new Date();
  date_fin_estimee : Date = new Date();
  dead_line : Date = new Date(); 
  respo_email: String = "";

  constructor(private projectService : ProjectService , private router: Router,private http : HttpClient){}

  onSubmit(){
    const formData = {
      title : this.title,
      date_debut: this.date_debut,
      date_fin_estimee: this.date_fin_estimee,
      dead_line : this.dead_line,
    }
    
    this.projectService.createProject(JSON.stringify(formData));
    this.router.navigate(['/dashboard']);


  }
}

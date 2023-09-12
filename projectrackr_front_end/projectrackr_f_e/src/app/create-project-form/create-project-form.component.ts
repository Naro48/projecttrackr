import { Component, OnInit } from '@angular/core';
import { faAdd } from '@fortawesome/free-solid-svg-icons';
import { NgModel } from '@angular/forms';
import { ProjectService } from '../service/project.service';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { error } from 'highcharts';
import { ProjetEntity } from 'src/entities/projet-entity';
import { AppConfig } from '../config';



@Component({
  selector: 'app-create-project',
  templateUrl: './create-project-form.component.html',
  styleUrls: ['./create-project-form.component.scss']
})
export class CreateProjectFormComponent implements OnInit{
  faAdd = faAdd; 

  isEditMode : boolean = false;

  projectToUpdate: any ;

  emailProjectToUpdate : string = ""; 

  debut_date_update : Date = new Date();
  final_date_update : Date = new Date();
  dead_line_update : Date = new Date();

  title : string = "" ; 
  date_debut: Date = new Date();
  date_fin_estimee : Date = new Date();
  dead_line : Date = new Date(); 
  respo_email: String = "";

  constructor(private projectService : ProjectService , private router: Router,private http : HttpClient,
    private route:ActivatedRoute){}
  
  
  ngOnInit(): void {
    this.route.queryParams.subscribe(params =>
      {
        this.projectId = params['projectId'];
        this.isEditMode = !!this.projectId;})

        if (this.isEditMode) {
          this.loadProject();
          
        }
  }
  
  
  loadProject(){
    this.projectService.getProjectById(this.projectId).subscribe(
      (project) => {
        this.projectToUpdate = project; 
        this.debut_date_update= project.date_debut;
        this.final_date_update= project.date_fin_estime;
        this.dead_line_update= project.dead_line;

        console.log(project);
        
      },
      (error) => {
        console.error('Erreur lors du chargement des details du projet :',error);
      }
    );
    this.http.get<any>(`${AppConfig.apiUrl}/projets/email/${this.projectId}`).subscribe(
      (fonctionnaire : any) => {
        this.emailProjectToUpdate = fonctionnaire.email;
      },
      (error) => {
        console.error("Erreur");
      }
    );

  }

  projectId : number = 0;

  onSubmit(){
    
    
    if (!this.isEditMode){
    const formData = {
      title : this.title,
      date_debut: this.date_debut,
      date_fin_estimee: this.date_fin_estimee,
      dead_line : this.dead_line,
      respo_email : this.respo_email
    }
    
    this.projectService.createProject(formData).subscribe(
      (createdProject) => {
        console.log("New project created : ", createdProject);
        localStorage.setItem("ProjectId",createdProject.id.toString());
        this.router.navigate(['/task_creation'],{queryParams : {projectId: createdProject.id}});
        
      },
      (error) => {
        console.error('Error creating project: ', error);
      }
    );
    }

    else {
      const UpdatedData = {
        title : this.title,
        date_debut: this.date_debut,
        date_fin_estimee: this.date_fin_estimee,
        dead_line : this.dead_line,
        respo_email : this.respo_email
      }
      this.projectService.updateProject(UpdatedData,this.projectId).subscribe(
        (updatedProject) => {
          console.log(UpdatedData);
          console.log("Project Updated");
          this.router.navigate(['/projets']);
        },
        (error) => {
          console.error("Erreur");
        }
      )
    }


  }

  formatDate(){
    
  }

}

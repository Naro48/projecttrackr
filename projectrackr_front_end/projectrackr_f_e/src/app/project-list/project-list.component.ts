import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppConfig } from '../config';
import { ProjectService } from '../service/project.service';
import { ProjetEntity } from 'src/entities/projet-entity';
import { faEdit, faTasks, faTrash } from '@fortawesome/free-solid-svg-icons';
import { error } from 'highcharts';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit{
  
  faTasks = faTasks;

  faEdit = faEdit;

  faDelete = faTrash;


  projects :ProjetEntity[] = [];

  constructor(private http: HttpClient,private router:Router,private projectService : ProjectService,
    private route : ActivatedRoute){}

  
  


  ngOnInit(){
    this.loadProjects();
  }

  loadProjects() {
    this.projectService.findAllProjects().subscribe(
      (projects: ProjetEntity[]) => {
        this.projects = projects;
        console.log(projects);
      },
      (error) => {
        console.error('Error fetching projects:', error);
      }
    );
  }
  OnSubmit(projectId : number){
    this.router.navigate(['/creation'],{queryParams: {projectId:projectId}});
  }

  Delete(projectId : number){
    this.projectService.deleteProjectById(projectId).subscribe(
      (response : any) => {
        console.log("deleted");
        this.ngOnInit();
      },
      (error) => {
        console.error("erreur");
      }
    );
  }






}

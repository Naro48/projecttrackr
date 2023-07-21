import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppConfig } from '../config';
import { ProjectService } from '../service/project.service';
import { ProjetEntity } from 'src/entities/projet-entity';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit{
    


  projects :ProjetEntity[] = [];

  constructor(private http: HttpClient,private router:Router,private projectService : ProjectService){}

  
  


  ngOnInit(){
    this.loadProjects();
  }

  loadProjects() {
    this.projectService.findAllProjects().subscribe(
      (projects: ProjetEntity[]) => {
        this.projects = projects;
      },
      (error) => {
        console.error('Error fetching projects:', error);
      }
    );
  }






}

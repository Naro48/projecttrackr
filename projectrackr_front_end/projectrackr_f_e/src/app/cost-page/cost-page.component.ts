import { Component, OnInit } from '@angular/core';
import { ProjetEntity } from 'src/entities/projet-entity';
import { ProjectService } from '../service/project.service';
import { AppConfig } from '../config';
import { HttpClient } from '@angular/common/http';
import { error } from 'highcharts';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-cost-page',
  templateUrl: './cost-page.component.html',
  styleUrls: ['./cost-page.component.scss']
})
export class CostPageComponent implements OnInit{
  
  constructor(private projectService : ProjectService,private http : HttpClient){}
  
  projects : any[] = []; 
  
  projectsTdev : number[] = [];

  projectsPm : number[] = [];
  
  ngOnInit(): void {
    this.loadProjectDetails();
  }

  loadProjectDetails(){
    this.projectService.findAllProjects().subscribe(
      (projects: any[]) => {
        this.projects = projects;
      },
      (error) => {
        console.error('Error fetching projects:', error);
      }
    );

    for (const project of this.projects){
      this.loadPm(project.id).subscribe(
        (pm:number) => {
          this.projectsPm.push(pm);
        },
        (error) => {
          console.error("Erreur");
        }
      );
      this.loadTdev(project.id).subscribe(
        (tdev : number) => {
          this.projectsTdev.push(tdev)
        },
        (error) => {
          console.error("Erreur ");
        }
      )
    }
  }
  
  loadPm(projectId : number) : Observable<number>{
    return this.http.get<number>(`${AppConfig.apiUrl}/projets/pm/${projectId}`);
  }

  loadTdev(projectId : number) : Observable<number>{
    return this.http.get<number>(`${AppConfig.apiUrl}/projets/tdev/${projectId}`);
  }
}

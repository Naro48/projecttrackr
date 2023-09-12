import { Component, OnInit } from '@angular/core';
import {
  faLocation,
  faShop,
  faBoxes,
  faMoneyBill,
  faFile,
  faCheckSquare,
  faUsers,
} from '@fortawesome/free-solid-svg-icons';

import { TaskEntity } from 'src/entities/task-entity';
import { TaskService } from '../service/task.service';
import { ProjectService } from '../service/project.service';
import { HttpClient } from '@angular/common/http';
import { AppConfig } from '../config';
import { error } from 'highcharts';

@Component({
  selector: 'app-top-widgets',
  templateUrl: './top-widgets.component.html',
  styleUrls: ['./top-widgets.component.scss']
})
export class TopWidgetsComponent implements OnInit {

  numberOfTasks : number = 0;

  numberOfProjects: number = 0; 

  numberOfUsers : number = 0; 

  totalPm : string = "";


  faLocation = faLocation;
  faShop = faShop;
  faBoxes = faBoxes;
  faMoneyBill = faMoneyBill;
  faFile = faFile;
  faCheckSquare = faCheckSquare;
  faUsers = faUsers;

  constructor(private taskService :TaskService,private projectService: ProjectService, private http : HttpClient) { }

  ngOnInit() {
    this.taskService.getNumberOfTasks().subscribe(
      (numberOfTasks: number) => {
        this.numberOfTasks = numberOfTasks;
      },
      (error) => {
        console.error("Erreur lors de la récupération du nombre de tâches", error);
      }
    );

    this.projectService.getNumberOfProjects().subscribe(
      (numberOfProjects: number) => {
        this.numberOfProjects = numberOfProjects;
      },
      (error) => {
        console.error("Erreur lors de la récupération du nombre de projets", error);
      }
    );

    this.http.get<number>(`${AppConfig.apiUrl}/projets/all_users`).subscribe(
      (numberOfUsers : number) => {
        this.numberOfUsers = numberOfUsers;
      },
      (error) => {
        console.error("Erreur de la recuperation du nombre des fonctionnaires")
      }
    );
    this.http.get<number>(`${AppConfig.apiUrl}/projets/pm/all`).subscribe(
      (TotalPm:number) => {
        this.totalPm = TotalPm.toFixed(2);
      },
      (error) => {
        console.error("Erreur de recuperation de l'effort Total");
      }
    );

  }

}
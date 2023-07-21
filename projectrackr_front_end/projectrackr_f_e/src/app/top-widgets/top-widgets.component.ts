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

@Component({
  selector: 'app-top-widgets',
  templateUrl: './top-widgets.component.html',
  styleUrls: ['./top-widgets.component.scss']
})
export class TopWidgetsComponent implements OnInit {

  numberOfTasks : number = 0;

  numberOfProjects: number = 0; 



  faLocation = faLocation;
  faShop = faShop;
  faBoxes = faBoxes;
  faMoneyBill = faMoneyBill;
  faFile = faFile;
  faCheckSquare = faCheckSquare;
  faUsers = faUsers;

  constructor(private taskService :TaskService,private projectService: ProjectService) { }

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

  }

}
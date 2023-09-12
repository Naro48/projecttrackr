import { Component, OnInit } from '@angular/core';
import { TaskService } from '../service/task.service';
import { ActivatedRoute, Router } from '@angular/router';
import { faEdit, faTasks, faTrash } from '@fortawesome/free-solid-svg-icons';
import { ProjectService } from '../service/project.service';
import { ProjetEntity } from 'src/entities/projet-entity';
import { error } from 'highcharts';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.scss']
})
export class TaskComponent implements OnInit {
  projectId : number = 0; 
  nameOfProject : string = ""; 
  tasks : any[] = []; 

  taskId: number = 0;

  faTasks = faTasks;

  faEdit = faEdit;

  faDelete = faTrash;

  constructor(private projectService : ProjectService,private taskService : TaskService, private router : Router, private route : ActivatedRoute){}



  ngOnInit(): void {
      this.projectId = parseInt(this.route.snapshot.paramMap.get('projectId')!);
      this.projectService.getProjectById(this.projectId).subscribe(
        (project : ProjetEntity) => {
          this.nameOfProject = project.title;
        },
        (error) => {
          console.error(error);
        }
      );
      this.loadTasks();
  }
  loadTasks(){
    this.taskService.getAllTasksByProjectId(this.projectId).subscribe(
      (taskInfo :any[]) => {
        this.tasks = taskInfo; 
        console.log(this.tasks);
      },
      (error) => {
        console.log("Erreur de recuperation des projets");
      }
    )
  }
  OnSubmit(){
    this.router.navigate(['/task_creation'],{queryParams : {projectId: this.projectId}});
  }
  OnSubmitSub(taskId : number){
    this.router.navigate(['/task_creation'],{queryParams : {projectId: this.projectId ,taskId:taskId}});
  }

  OnSubmitUpdate(taskId : number){
    this.router.navigate(['/task_creation'],{queryParams: {taskToUpdateId:taskId, projectId:this.projectId}});
  }

  Delete(taskId : number){
    this.taskService.deleteTask(taskId).subscribe(
      (response : any) => {
        console.log("done");
        this.ngOnInit();
      },
      (error) => {
        console.error('Erreur');
      }
    )
  }
}

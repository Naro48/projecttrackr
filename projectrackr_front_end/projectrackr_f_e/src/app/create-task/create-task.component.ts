import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { faAdd } from '@fortawesome/free-solid-svg-icons';
import { TaskService } from '../service/task.service';
import { CreateProjectComponent } from '../create-project/create-project.component';
import { CreateProjectFormComponent } from '../create-project-form/create-project-form.component';
import { ActivatedRoute } from '@angular/router';
import { error } from 'highcharts';
import { TaskEntity } from 'src/entities/task-entity';
import { AppConfig } from '../config';


@Component({
  selector: 'app-create-task',
  templateUrl: './create-task.component.html',
  styleUrls: ['./create-task.component.scss']
})
export class CreateTaskComponent implements OnInit{
  faAdd = faAdd; 

  title : string = "" ; 
  date_debut: Date = new Date();
  date_fin_estimee : Date = new Date();
  dead_line : Date = new Date(); 
  respo_email: String = "";
  description : String = "";
  priority :String = "";
  num_ligne_code: number = 0;
  projectId: number = 0;

  taskId : number = 0 ; 

  respoUser : any = [];

  parentTaskId : number =0; 

  taskToUpdateId: number = 0;

  isEditMode : boolean = false; 

  taskToUpdate : TaskEntity = new TaskEntity();


  constructor(private route : ActivatedRoute,private taskService : TaskService , private router: Router,private http : HttpClient,
    private createProject : CreateProjectFormComponent){this.route.queryParams.subscribe((params) => {
      this.projectId = params['projectId'];
      this.parentTaskId = params['taskId'];
      this.taskToUpdateId = params['taskToUpdateId']
      this.isEditMode = !!this.taskToUpdateId;
    });}
  ngOnInit(): void {
    this.loadTask();
  }

  loadTask(){
    this.taskService.getTaskById(this.taskToUpdateId).subscribe(
      (task:TaskEntity) => {
        this.taskToUpdate = task ; 
        console.log(task);

      },
      (error) => {
        console.error("Erreur de recuperation de la tâche");
      }
    );
    this.http.get<any>(`${AppConfig.apiUrl}/tasks/respo/${this.taskToUpdateId}`).subscribe(
      (user :any) => {
        this.respoUser = user ;
      },
      (error) => {
        console.error("Erreur");
      }
    )
  }
    
  onSubmit(){

    if (!this.isEditMode){
    const formData = {
      title : this.title,
      date_debut: this.date_debut,
      date_fin_estimee: this.date_fin_estimee,
      dead_line : this.dead_line,
      respo_email : this.respo_email,
      description : this.description,
      priority : this.priority,
      num_ligne_code : this.num_ligne_code,
      projectId: this.projectId
    }
    
    this.taskService.createTask(formData).subscribe(
      (createdTask) => {
        console.log("New Task created : ", createdTask);
        this.router.navigate(['/costs'],{queryParams: {taskId : createdTask.id}});
      },
      (error) => {
        console.error('Error creating task: ', error);
      }
    );
    }

    else {
      const UpdatedData = {
      title : this.title,
      date_debut: this.date_debut,
      date_fin_estimee: this.date_fin_estimee,
      dead_line : this.dead_line,
      respo_email : this.respo_email,
      description : this.description,
      priority : this.priority,
      num_ligne_code : this.num_ligne_code,
      projectId : this.projectId
      }

      this.taskService.updateTask(this.taskToUpdateId,UpdatedData).subscribe(
        (updatedTask) => {
          console.log("Task Updated");
          console.log(UpdatedData);
          this.router.navigate([`/tasks/${this.projectId}`]);
        },
        (error) => {
          console.error("Erreur");
        }
      )
    }


  }
}

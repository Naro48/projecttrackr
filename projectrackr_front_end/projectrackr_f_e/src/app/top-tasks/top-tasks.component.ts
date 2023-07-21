import { Component, OnInit } from '@angular/core';
import { TaskService } from '../service/task.service';
import {HighchartsChartComponent} from 'highcharts-angular';
@Component({
  selector: 'app-top-tasks',
  templateUrl: './top-tasks.component.html',
  styleUrls: ['./top-tasks.component.css']
})
export class TopTasksComponent implements OnInit{
  
  


  constructor(private taskService : TaskService) {}

  ngOnInit(): void {
  }

}

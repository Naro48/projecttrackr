import { Component } from '@angular/core';
import { NgModel } from '@angular/forms';
import { TaskService } from '../service/task.service';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { CostService } from '../service/cost.service';
import { error } from 'highcharts';

@Component({
  selector: 'app-costs',
  templateUrl: './costs.component.html',
  styleUrls: ['./costs.component.scss']
})
export class CostsComponent {
  ratings : string[] = [];
  taskId : number = 0 ; 

  constructor(private costService : CostService,private taskService : TaskService ,private router : Router,private route: ActivatedRoute ){this.route.queryParams.subscribe((params) => {
    this.taskId = params['taskId'];
  });}

  onSubmit(){
    this.costService.createCost(this.taskId,this.ratings).subscribe(
      (createdCost) => {
        this.router.navigate(['/dashboard']);
      },
      (error) => {
        console.log(this.ratings);
      }
    );
  }

}

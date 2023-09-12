import { Component, OnInit } from '@angular/core';
import { AppConfig } from '../config';
import { HttpClient } from '@angular/common/http';
import { Chart } from 'chart.js';

@Component({
  selector: 'app-pie-task',
  templateUrl: './pie-task.component.html',
  styleUrls: ['./pie-task.component.css']
})
export class PieTaskComponent implements OnInit{
  
  
  
  
  chart : any ; 

  constructor(private http : HttpClient){
  }
  
  usersTo : any ; 

  dataSet : any[] = [];

  usersName : string[] = [];

  chartsData : any[] = [];

  ngOnInit(): void {
    this.loadDataPie();

    



  }

  loadDataPie(){
    this.http.get<any>(`${AppConfig.apiUrl}/projets/find_users`).subscribe(
      (users:any[]) => {
        this.usersTo = users;

        this.usersName = users.map(user => user.nom);

        this.dataSet = users.map(user => user.tasks.length);

        const colors = Array.from({ length: this.dataSet.length }, () => this.getRandomColor());

        this.createPieChart(this.dataSet,this.usersName,colors);

      },
      (error) => {
        console.error("Erreur de recuperation des fonctionnaires");
      }

    )
  }
  
  getRandomColor() {
    const letters = "0123456789ABCDEF";
    let color = "#";
    for (let i = 0; i < 6; i++) {
      color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
  }

  createPieChart(data:number[], labels: string[],colors:string[]){
    this.chart = new Chart("MyChartPieTasks", {
      type: 'pie', //this denotes tha type of chart

      data: {// values on X-Axis
        labels: labels, 
         datasets: [
          {
            label: "Nombre de tâches",
            data: data,
            backgroundColor: colors,
            hoverOffset : 5
            
          },
          
        ]
      },
      options: {
        aspectRatio:0.9,
        responsive:false
      }
      
    });
  }
}

import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js';
import { AppComponent } from '../app.component';
import { AppConfig } from '../config';
import { error } from 'highcharts';
import { ChartDataset, ChartOptions, ChartType } from 'chart.js';


@Component({
  selector: 'app-project-chart',
  templateUrl: './project-chart.component.html',
  styleUrls: ['./project-chart.component.css']
})
export class ProjectChartComponent implements OnInit {
  
  barChartOptions = {
    responsive: true,
    scales: { y: { beginAtZero: true } }
  };
  barChartLabels: string[] = [];
  barChartData: any[] = [];
  
  
  constructor(private http : HttpClient){}
  
  
  public chart : any;  
  
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;

  public barChartDataDisplay: ChartDataset[] = [
    {
    data: this.barChartData,
    label: 'Effort'
    }
  ] ;

  public barChartLabelsDisplay: any[] = this.barChartLabels;




  ngOnInit(): void {
    this.http.get<any[]>(`${AppConfig.apiUrl}/projets/pm`).subscribe(
      (infos) => {
        this.barChartLabels = Object.keys(infos);
        this.barChartData = Object.values(infos);
        this.createChart(this.barChartData,this.barChartLabels)
      },
      (error) => {
        console.error("Erreur de recuperation des informations ");
      }
    );

    ;

  }

  createChart(labelData:any[], realData:any[]){
  
      this.chart = new Chart("MyChart", {
        type: 'bar', //this denotes tha type of chart
  
        data: {// values on X-Axis
          labels: realData, 
           datasets: [
            {
              label: "Effort Total en Personne-Mois",
              data: labelData,
              backgroundColor: "#77003a"
            },
            
          ]
        },
        options: {
          aspectRatio:3
        }
        
      });
    }
  
  }


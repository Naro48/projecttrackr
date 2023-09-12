import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../service/project.service';
import { Chart } from 'chart.js';

@Component({
  selector: 'app-line-chart',
  templateUrl: './line-chart.component.html',
  styleUrls: ['./line-chart.component.css']
})
export class LineChartComponent implements OnInit{
  
  ngOnInit(): void {
    this.loadProjectDetailsAgain();
  }
  public lineChartData: any[] = [{ data: [], label: 'Projets Débutés' }];
  
  projets: any[] = [] ;

  chart : any ;

  lineChartLabels : string[] =[] ; 

  constructor(private projectService : ProjectService){}

  loadProjectDetailsAgain(){
    this.projectService.findAllProjects().subscribe(
      (projects) => {
        this.projets = projects;

        const projetsParMois = this.compterProjetsParMois();

        this.lineChartData[0].data = this.lineChartLabels.map(mois => projetsParMois.get(mois) || 0);

        this.createLineChart(this.lineChartData,this.lineChartLabels);

      }
    );


  }
  compterProjetsParMois(){
    const projetsParMois = new Map<string,number>();
    const moisFormat = new Intl.DateTimeFormat('fr',{month:'long'});

    this.projets.forEach(project => {
      const dateDebut = new Date(project.date_debut);
      const mois = moisFormat.format(dateDebut);
      const nombreProjets = projetsParMois.get(mois) || 0;
      projetsParMois.set(mois, nombreProjets+1);

    });
    this.lineChartLabels =Array.from(projetsParMois.keys());

    return projetsParMois;
  }
  createLineChart(data:any[], labels: string[]){
    this.chart = new Chart("MyChartLine", {
      type: 'line', //this denotes tha type of chart

      data: {// values on X-Axis
        labels: labels, 
        datasets: data
      },
      options:{
      }
    });
  }

}

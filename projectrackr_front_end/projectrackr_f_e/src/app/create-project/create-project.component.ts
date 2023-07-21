import { Component } from '@angular/core';
import { faAdd } from '@fortawesome/free-solid-svg-icons';
@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.scss']
})
export class CreateProjectComponent {
  faAdd = faAdd; 

  constructor(){}

  onSubmit(){
    
  }
}

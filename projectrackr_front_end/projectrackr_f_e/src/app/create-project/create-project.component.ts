import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { faAdd, faSearch, faTasks } from '@fortawesome/free-solid-svg-icons';
@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.scss']
})
export class CreateProjectComponent {
  faAdd = faAdd; 

  faSearch = faSearch

  faTasks = faTasks;

  constructor(private router : Router){}

  OnSubmit(){
    this.router.navigate(['/creation']);
  }
}

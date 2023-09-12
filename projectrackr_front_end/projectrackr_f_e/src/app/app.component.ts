import { Component } from '@angular/core';
import { ProjectService } from './service/project.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'projectrackr_f_e';

  constructor(private projectService : ProjectService){}

  
}

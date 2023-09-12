import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CreateProjectComponent } from './create-project/create-project.component';
import { CreateProjectFormComponent } from './create-project-form/create-project-form.component';
import { CreateTaskComponent } from './create-task/create-task.component';
import { CostsComponent } from './costs/costs.component';
import { TaskComponent } from './task/task.component';
import { UsersComponent } from './users/users.component';
import { CostPageComponent } from './cost-page/cost-page.component';

const routes: Routes = [
  { path: 'login', component:LoginComponent},
  { path : 'register' ,component:RegisterComponent},
  { path: 'dashboard' , component: DashboardComponent},
  { path : 'projets' , component: CreateProjectComponent},
  { path : 'creation', component: CreateProjectFormComponent},
  { path : 'task_creation', component : CreateTaskComponent},
  { path : 'costs', component : CostsComponent},
  { path : 'tasks/:projectId', component :TaskComponent},
  { path : 'users', component:UsersComponent},
  { path : 'cost_page',component: CostPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

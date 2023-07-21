import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CreateProjectComponent } from './create-project/create-project.component';
import { CreateProjectFormComponent } from './create-project-form/create-project-form.component';

const routes: Routes = [
  { path: 'login', component:LoginComponent},
  { path : 'register' ,component:RegisterComponent},
  { path: 'dashboard' , component: DashboardComponent},
  { path : 'projets' , component: CreateProjectComponent},
  { path : 'creation', component: CreateProjectFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

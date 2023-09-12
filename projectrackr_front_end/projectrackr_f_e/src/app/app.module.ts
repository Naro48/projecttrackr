import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';


import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { RegisterComponent } from './register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SideNavComponent } from './side-nav/side-nav.component';
import { HeaderDashComponent } from './header-dash/header-dash.component';
import { MainComponent } from './main/main.component';
import { TopWidgetsComponent } from './top-widgets/top-widgets.component';
import { ProjectListComponent } from './project-list/project-list.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from './auth-interceptor';
import { TokenStorageService } from './service/auth-storage.service';
import { HighchartsChartModule } from 'highcharts-angular';
import * as highcharts from 'highcharts';
import { TopTasksComponent } from './top-tasks/top-tasks.component';
import { CreateProjectComponent } from './create-project/create-project.component';
import { CreateProjectFormComponent } from './create-project-form/create-project-form.component';
import { CreateTaskComponent } from './create-task/create-task.component';
import { CostsComponent } from './costs/costs.component';
import { TaskComponent } from './task/task.component';
import { UsersComponent } from './users/users.component';
import { CostPageComponent } from './cost-page/cost-page.component';
import { ProjectChartComponent } from './project-chart/project-chart.component';

import { ChartOptions, ChartType, ChartDataset} from 'chart.js';
import { NgChartsModule } from 'ng2-charts';
import { PieChartComponent } from './pie-chart/pie-chart.component';
import { PieTaskComponent } from './pie-task/pie-task.component';
import { LineChartComponent } from './line-chart/line-chart.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    RegisterComponent,
    DashboardComponent,
    SideNavComponent,
    HeaderDashComponent,
    MainComponent,
    TopWidgetsComponent,
    ProjectListComponent,
    TopTasksComponent,
    CreateProjectComponent,
    CreateProjectFormComponent,
    CreateTaskComponent,
    CostsComponent,
    TaskComponent,
    UsersComponent,
    CostPageComponent,
    ProjectChartComponent,
    PieChartComponent,
    PieTaskComponent,
    LineChartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    FontAwesomeModule,
    HighchartsChartModule,
    NgChartsModule
  ],
  providers: [ {provide: HTTP_INTERCEPTORS , useClass :AuthInterceptor, multi : true}
  , CreateProjectFormComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }

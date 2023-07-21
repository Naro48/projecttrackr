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
    CreateProjectFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    FontAwesomeModule,
    HighchartsChartModule
  ],
  providers: [ {provide: HTTP_INTERCEPTORS , useClass :AuthInterceptor, multi : true}],
  bootstrap: [AppComponent]
})
export class AppModule { }

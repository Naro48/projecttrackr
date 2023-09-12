import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppConfig } from '../config';
import { error } from 'highcharts';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit{
  
  constructor(private http : HttpClient,private router :Router){}
  
  usersTo : any[] = [] ; 
  
  ngOnInit(): void {
    this.loadUsers();

  }
  loadUsers(){
    this.http.get<any>(`${AppConfig.apiUrl}/projets/find_users`).subscribe(
      (users:any[]) => {
        this.usersTo = users; 
      },
      (error) => {
        console.error("Erreur de recuperation des fonctionnaires");
      }

    )
  }
}

import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { AppConfig } from "../config";
import { ProjetEntity } from "src/entities/projet-entity";
import { Observable, map } from "rxjs";

@Injectable({
    providedIn: 'root'
})


export class ProjectService {
    private apiUrl = AppConfig.apiUrl;

    constructor(private http:HttpClient){}
    
    

      createProject(projectData: any): Observable<ProjetEntity> {
        const endpoint = `${this.apiUrl}/projets/creation_projet`;
        return this.http.post<ProjetEntity>(endpoint,projectData, {headers: new HttpHeaders({
          'Content-Type' : 'application/json'})});
      }
    
      searchProjectByTitle(title: string): Observable<ProjetEntity[]> {
        const endpoint = `${this.apiUrl}/projets/search`;
        return this.http.post<ProjetEntity[]>(endpoint, title);
      }
    
      getProjectById(id: number): Observable<ProjetEntity> {
        const endpoint = `${this.apiUrl}/projets/find/${id}`;
        return this.http.get<ProjetEntity>(endpoint);
      }
    
      deleteAllProjects(): Observable<void> {
        const endpoint = `${this.apiUrl}/projets/delete/all`;
        return this.http.delete<void>(endpoint);
      }
    
      deleteProjectById(id: number): Observable<void> {
        const endpoint = `${this.apiUrl}/projets/delete/${id}`;
        return this.http.delete<void>(endpoint);
      }
    
      findAllProjects(): Observable<ProjetEntity[]> {
        const endpoint = `${this.apiUrl}/projets/find/all`;
        return this.http.get<ProjetEntity[]>(endpoint);
      }

      getNumberOfProjects(): Observable<number> {
        return this.findAllProjects().pipe(
          map((projects : ProjetEntity[]) => projects.length));
        
      }
    
      updateProject(projectData: any, projectId : number): Observable<ProjetEntity> {
        const endpoint = `${this.apiUrl}/projets/update/${projectId}`;
        return this.http.post<ProjetEntity>(endpoint, projectData);
      }
    }
    
    


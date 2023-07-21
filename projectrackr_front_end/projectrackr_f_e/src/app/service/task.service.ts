import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { TaskEntity } from 'src/entities/task-entity'; // Assurez-vous d'importer correctement l'entité TaskEntity
import { AppConfig } from '../config';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private apiUrl = `${AppConfig.apiUrl}/tasks`; 

  constructor(private http: HttpClient) { }

  // Méthode pour créer une tâche
  createTask(task: TaskEntity): Observable<TaskEntity> {
    return this.http.post<TaskEntity>(`${this.apiUrl}/create_task`, task);
  }

  // Méthode pour créer une sous-tâche
  createSubTask(taskId: number, subtask: TaskEntity): Observable<TaskEntity> {
    return this.http.post<TaskEntity>(`${this.apiUrl}/${taskId}/subtasks`, subtask);
  }

  // Méthode pour récupérer une tâche par son ID
  getTaskById(taskId: number): Observable<TaskEntity> {
    return this.http.get<TaskEntity>(`${this.apiUrl}/${taskId}`);
  }

  // Méthode pour rechercher des tâches par nom
  searchTasksByName(keyword: string): Observable<TaskEntity[]> {
    return this.http.get<TaskEntity[]>(`${this.apiUrl}/search?keyword=${keyword}`);
  }

  // Méthode pour récupérer toutes les tâches
  getAllTasks(): Observable<TaskEntity[]> {
    return this.http.get<TaskEntity[]>(`${this.apiUrl}/all`);
  }

  getNumberOfTasks(): Observable<number> {
    return this.http.get<TaskEntity[]>(`${this.apiUrl}/all`)
      .pipe(
        map((tasks : TaskEntity[]) => tasks.length));
    
    }


  // Méthode pour récupérer toutes les tâches d'un projet spécifique
  getAllTasksByProjectId(projectId: number): Observable<TaskEntity[]> {
    return this.http.get<TaskEntity[]>(`${this.apiUrl}/project/${projectId}`);
  }

  // Méthode pour mettre à jour une tâche
  updateTask(taskId: number, updatedTask: TaskEntity): Observable<TaskEntity> {
    return this.http.put<TaskEntity>(`${this.apiUrl}/${taskId}`, updatedTask);
  }

  // Méthode pour supprimer une tâche
  deleteTask(taskId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${taskId}`);
  }
}

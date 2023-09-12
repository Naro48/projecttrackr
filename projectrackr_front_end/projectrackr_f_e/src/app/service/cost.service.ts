import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { AppConfig } from '../config';
import { TaskEntity } from 'src/entities/task-entity';
import { CostEntity } from 'src/entities/cost-entity';

@Injectable({
  providedIn: 'root'
})
export class CostService {

  private baseUrl = `${AppConfig.apiUrl}/cost`;

  constructor(private http: HttpClient) { }

  createCost(taskId: number, ratings: string[]): Observable<CostEntity> {
    return this.http.post<CostEntity>(`${this.baseUrl}/create/${taskId}`,ratings);
  }

  updateCost(costId: number, ratings: string[], poids: number): Observable<CostEntity> {
    return this.http.post<CostEntity>(`${this.baseUrl}/${costId}/update`, null, { params: { ratings: ratings, poids: poids.toString() } });
  }
}

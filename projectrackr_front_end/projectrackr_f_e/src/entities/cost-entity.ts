import { TaskEntity } from "./task-entity";

export class CostEntity {
    id : number = 0;
    task :TaskEntity[] = [];
    costFactors : any[] = [];
    rating: String[] = [];
    poid : number = 0 ;
}
import { TaskEntity } from "./task-entity";

export class ProjetEntity {
    id: number= 0; // Identifiant du projet (généré par la base de données)
    title: string =""; // Titre du projet
    date_debut: Date = new Date(); // Date de début du projet
    date_fin_estime: Date = new Date(); // Date de fin estimée du projet
    dead_line: Date= new Date();
    tasks : TaskEntity[] = [];
    constructor(){}
  }
  
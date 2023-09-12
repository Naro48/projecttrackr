export class TaskEntity{
    id : number =0;
    title : string = "" ; 
    date_debut: Date = new Date();
    date_fin_estimee : Date = new Date();
    dead_line : Date = new Date(); 
    respo_email: String = "";
    description : String = "";
    priority :String = "";
    num_ligne_code: number =0;
    projectId: number = 0;
}
package dev.nar.projectrackr.service;

import dev.nar.projectrackr.entities.FonctionnaireEntity;
import dev.nar.projectrackr.entities.ProjetEntity;
import dev.nar.projectrackr.entities.TaskEntity;
import dev.nar.projectrackr.exception.ProjectNotFoundException;
import dev.nar.projectrackr.repositories.FonctionnaireRepository;
import dev.nar.projectrackr.repositories.ProjetRepository;
import dev.nar.projectrackr.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjetServiceImpl implements ProjetService {
    private final ProjetRepository projetRepository;

    private final TaskRepository taskRepository;

    private final FonctionnaireRepository fonctionnaireRepository;


    @Autowired
    public ProjetServiceImpl(ProjetRepository projetRepository, TaskRepository taskRepository, FonctionnaireRepository fonctionnaireRepository, FonctionnaireRepository fonctionnaireRepository1) {
        this.projetRepository = projetRepository;
        this.taskRepository = taskRepository;
        this.fonctionnaireRepository = fonctionnaireRepository1;
    }

    public ProjetEntity addProject(ProjetEntity projet){
        return projetRepository.save(projet);

    }

    @Override
    public ProjetEntity createProject(String title, Date date_debut, Date date_fin_estimee, Date dead_line , String respo_email) {
        if (title == null || date_debut == null || date_fin_estimee == null || dead_line == null || respo_email == null) {
            throw new IllegalArgumentException("Certaines Informations nécessaires sont manquantes");
        }
        ProjetEntity projet = new ProjetEntity();

        projet.setTitle(title);
        projet.setDate_debut(date_debut);
        projet.setDate_fin_estime(date_fin_estimee);
        projet.setDead_line(dead_line);
        projet.setRespo_projet(fonctionnaireRepository.findByEmail(respo_email));



        return projetRepository.save(projet);

    }



    public ProjetEntity getProjectById(Integer id){
        return projetRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException("Project By Id "+id+"Not Found") );
    }
    public void deleteProjectById(Integer id){
        projetRepository.deleteById(id);

    }
    public List<ProjetEntity> findAllProjects(){
        return projetRepository.findAll();
    }

    public void deleteAllProjects(){
        projetRepository.deleteAll();

    }

    @Override
    public FonctionnaireEntity GetProjectRespo(Integer id) {
        ProjetEntity projet = projetRepository.findById(id).orElseThrow();

        return projet.getRespo_projet();
    }

    public ProjetEntity updateProject(ProjetEntity projet){
        return projetRepository.save(projet);
    }

    @Override
    public List<ProjetEntity> searchProjectByTitle(String title) {
        return projetRepository.findByTitleIgnoreCase(title);
    }

    @Override
    public Double getEffort(Integer id) {
        ProjetEntity projet = projetRepository.findById(id).orElseThrow();

        double Effort = 0.0 ;

        List<TaskEntity> tasks = projet.getTasks();

        for (TaskEntity task : tasks){
            if (task.getEffort() != null) Effort+= Double.parseDouble(task.getEffort());
            else continue;
        }

        return Effort;
    }

    @Override
    public Double getTimeDev(Integer id) {
        ProjetEntity projet = projetRepository.findById(id).orElseThrow();

        double tdev = 0.0 ;

        List<TaskEntity> tasks = projet.getTasks();

        for (TaskEntity task : tasks){
            tdev+= Double.parseDouble(task.getTdev());
        }



        return tdev;
    }


}



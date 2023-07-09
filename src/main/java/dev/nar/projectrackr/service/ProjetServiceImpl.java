package dev.nar.projectrackr.service;

import dev.nar.projectrackr.entities.ProjetEntity;
import dev.nar.projectrackr.exception.ProjectNotFoundException;
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

    @Autowired
    public ProjetServiceImpl(ProjetRepository projetRepository, TaskRepository taskRepository) {
        this.projetRepository = projetRepository;
        this.taskRepository = taskRepository;
    }

    public ProjetEntity addProject(ProjetEntity projet){
        return projetRepository.save(projet);

    }

    @Override
    public ProjetEntity createProject(String title, Date date_debut, Date date_fin_estimee, Date dead_line) {
        if (title == null || date_debut == null || date_fin_estimee == null || dead_line == null) {
            throw new IllegalArgumentException("Certaines Informations nécessaires sont manquantes");
        }
        ProjetEntity projet = new ProjetEntity();

        projet.setTitle(title);
        projet.setDate_debut(date_debut);
        projet.setDate_fin_estime(date_fin_estimee);
        projet.setDead_line(dead_line);

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

    public ProjetEntity updateProject(ProjetEntity projet){
        return projetRepository.save(projet);
    }

    @Override
    public List<ProjetEntity> searchProjectByTitle(String title) {
        return projetRepository.findByTitleIgnoreCase(title);
    }






}



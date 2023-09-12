package dev.nar.projectrackr.service;

import dev.nar.projectrackr.entities.FonctionnaireEntity;
import dev.nar.projectrackr.entities.ProjetEntity;

import java.util.Date;
import java.util.List;

public interface ProjetService {

    public ProjetEntity addProject(ProjetEntity projet);

    public ProjetEntity createProject(String tile,
                                      Date date_debut,
                                      Date date_fin_estimee,
                                      Date dead_line,
                                      String respo_email);

    public ProjetEntity getProjectById(Integer id);

    public void deleteProjectById(Integer id);

    public List<ProjetEntity> findAllProjects();

    public void deleteAllProjects();

    public FonctionnaireEntity GetProjectRespo(Integer id);

    public ProjetEntity updateProject(ProjetEntity projet);

    public List<ProjetEntity> searchProjectByTitle(String title);

    public Double getEffort(Integer id );

    public Double getTimeDev(Integer id);


}

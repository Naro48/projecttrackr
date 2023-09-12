package dev.nar.projectrackr.service;

import dev.nar.projectrackr.entities.FonctionnaireEntity;
import dev.nar.projectrackr.entities.ProjetEntity;
import dev.nar.projectrackr.entities.TaskEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TaskService {

    public TaskEntity createTask(ProjetEntity projet, String title, Date date_debut, Date date_fin_estimee, Date dead_line,String respo_email
            ,String description
            ,String priorité,Double num_ligne_code);

    public TaskEntity createSubTask(TaskEntity father_task, String title, Date date_debut, Date date_fin_estimee, Date dead_line);

    public FonctionnaireEntity getTaskRespo(Integer id);

    public TaskEntity getTaskById(Integer id);

    public List<TaskEntity> searchTaskByName(String keyword);

    public List<TaskEntity> findAllTasksByProjet(ProjetEntity projet);

    public List<TaskEntity> findAllTasks();

    public void deleteAllTasksByProjectId(int projectId);

    public TaskEntity updateTask(TaskEntity task);

    public void deleteTaskById(Integer id );


}
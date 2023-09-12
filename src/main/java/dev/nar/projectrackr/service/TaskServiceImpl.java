package dev.nar.projectrackr.service;

import dev.nar.projectrackr.entities.CostEntity;
import dev.nar.projectrackr.entities.FonctionnaireEntity;
import dev.nar.projectrackr.entities.ProjetEntity;
import dev.nar.projectrackr.entities.TaskEntity;
import dev.nar.projectrackr.exception.TaskNotFoundException;
import dev.nar.projectrackr.repositories.FonctionnaireRepository;
import dev.nar.projectrackr.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class TaskServiceImpl implements TaskService{


    private final TaskRepository taskRepository;

    private final FonctionnaireRepository fonctionnaireRepository;
    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, FonctionnaireRepository fonctionnaireRepository) {
        this.taskRepository = taskRepository;
        this.fonctionnaireRepository = fonctionnaireRepository;
    }


    @Override
    public TaskEntity createTask(ProjetEntity projet,
                                 String title,
                                 Date date_debut,
                                 Date date_fin_estimee,
                                 Date dead_line,
                                 String respo_email,
                                 String description,
                                 String priority,
                                 Double num_ligne_code) {
        TaskEntity task = new TaskEntity();
        task.setProjet(projet);
        task.setTitle(title);
        task.setDate_debut(date_debut);
        task.setDate_fin_estime(date_fin_estimee);
        task.setDead_line(dead_line);
        task.setDescription(description);
        task.setPriority(priority);
        task.setNum_ligne_code(num_ligne_code);

        task.setRespo_tâche(fonctionnaireRepository.findByEmail(respo_email));




        return taskRepository.save(task);
    }

    @Override
    public TaskEntity createSubTask(TaskEntity father_task,String title, Date date_debut, Date date_fin_estimee, Date dead_line) {
        TaskEntity task = new TaskEntity();
        task.setProjet(father_task.getProjet());
        task.setTitle(title);
        task.setDate_debut(date_debut);
        task.setDate_fin_estime(date_fin_estimee);
        task.setDead_line(dead_line);
        task.setFather_task(father_task);

        return taskRepository.save(task);
    }

    @Override
    public FonctionnaireEntity getTaskRespo(Integer id) {
        return taskRepository.findById(id).orElseThrow().getRespo_tâche();
    }


    @Override
    public TaskEntity getTaskById(Integer id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task by " + id + "Not found"));
    }

    @Override
    public List<TaskEntity> searchTaskByName(String keyword) {
        return taskRepository.findByTitleIgnoreCase(keyword);
    }

    @Override
    public List<TaskEntity> findAllTasksByProjet(ProjetEntity projet) {
        return taskRepository.getTasksByProjet(projet);
    }

    @Override
    public List<TaskEntity> findAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteAllTasksByProjectId(int projectId) {
        taskRepository.deleteAll();
    }



    @Override
    public TaskEntity updateTask(TaskEntity task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTaskById(Integer id) {
        taskRepository.deleteById(id);
    }


    public void addCosts(TaskEntity task,List<CostEntity> costs){

        task.setCosts(costs);

        taskRepository.save(task);

    }
}

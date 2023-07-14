package dev.nar.projectrackr.service;

import dev.nar.projectrackr.entities.CostEntity;
import dev.nar.projectrackr.entities.ProjetEntity;
import dev.nar.projectrackr.entities.TaskEntity;
import dev.nar.projectrackr.exception.TaskNotFoundException;
import dev.nar.projectrackr.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class TaskServiceImpl implements TaskService{


    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public TaskEntity createTask(ProjetEntity projet, String title, Date date_debut, Date date_fin_estimee, Date dead_line) {
        TaskEntity task = new TaskEntity();
        task.setProjet(projet);
        task.setTitle(title);
        task.setDate_debut(date_debut);
        task.setDate_fin_estime(date_fin_estimee);
        task.setDead_line(dead_line);


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


    public void addCosts(TaskEntity task,List<CostEntity> costs){

        task.setCosts(costs);

        taskRepository.save(task);

    }
}

package dev.nar.projectrackr.service;

import dev.nar.projectrackr.entities.ProjetEntity;
import dev.nar.projectrackr.entities.TaskEntity;
import dev.nar.projectrackr.exception.TaskNotFoundException;
import dev.nar.projectrackr.repositories.TaskRepository;

import java.util.Date;
import java.util.List;

public class TaskServiceImpl implements TaskService{


    private final TaskRepository taskRepository;

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
    public TaskEntity getTaskById(Integer id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task by " + id + "Not found"));
    }

    @Override
    public List<TaskEntity> searchTaskByName(String keyword) {
        return taskRepository.findByTitleContainingIgnoredCase(keyword);
    }

    @Override
    public List<TaskEntity> findAllTasksByProjectId(int projectId) {
        return taskRepository.getTasksByProjectId(projectId);
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

}
package dev.nar.projectrackr.controllers;

import dev.nar.projectrackr.entities.ProjetEntity;
import dev.nar.projectrackr.entities.TaskEntity;
import dev.nar.projectrackr.service.ProjetService;
import dev.nar.projectrackr.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    private final ProjetService projetService;

    public TaskController(TaskService taskService, ProjetService projetService) {
        this.taskService = taskService;
        this.projetService = projetService;
    }

    @PostMapping("/create_task")
    public TaskEntity createTask(@RequestBody TaskRequest taskRequest) {
        ProjetEntity projet = projetService.getProjectById(taskRequest.getProjetID());// Récupérer le projet associé à partir de l'identifiant fourni
        return taskService.createTask(projet, taskRequest.getTitle(), taskRequest.getDateDebut(), taskRequest.getDateFinEstimee(), taskRequest.getDeadLine());
    }

    @PostMapping("/{taskId}/subtasks")
    public TaskEntity createSubTask(@PathVariable Integer taskId, @RequestBody TaskRequest taskRequest) {
        TaskEntity fatherTask = taskService.getTaskById(taskId);

        return taskService.createSubTask(fatherTask,
                taskRequest.getTitle(),
                taskRequest.getDateDebut(),
                taskRequest.getDateFinEstimee(),
                taskRequest.getDeadLine());
    }

    @GetMapping("/{taskId}")
    public TaskEntity getTaskById(@PathVariable Integer taskId) {
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/search")
    public List<TaskEntity> searchTaskByName(@RequestParam("keyword") String keyword) {
        return taskService.searchTaskByName(keyword);
    }

    @GetMapping("/all")
    public List<TaskEntity> getAllTasks() {
        return taskService.findAllTasks();
    }

    @GetMapping("/project/{projectId}")
    public List<TaskEntity> getAllTasksByProjectId(@PathVariable Integer projectId) {
        ProjetEntity projet = projetService.getProjectById(projectId); // Récupérer le projet associé à partir de l'identifiant fourni
        return taskService.findAllTasksByProjet(projet);
    }

    @PutMapping("/{taskId}")
    public TaskEntity updateTask(@PathVariable Integer taskId, @RequestBody TaskRequest updatedTask) {
        TaskEntity task = taskService.getTaskById(taskId);
        // Mettre à jour les attributs de la tâche avec ceux fournis dans updatedTask
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public void deleteAllTasksByProjectId(@PathVariable Integer projectId) {
        taskService.deleteAllTasksByProjectId(projectId);
    }



    // Classe interne pour représenter une requête de création de tâche
    @Data
    @RequiredArgsConstructor
    @AllArgsConstructor
    private static class TaskRequest {
        private String title;
        private Date dateDebut;
        private Date dateFinEstimee;
        private Date deadLine;
        private int projetID;

        // Getters et setters
    }
}

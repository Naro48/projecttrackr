package dev.nar.projectrackr.controllers;

import dev.nar.projectrackr.entities.FonctionnaireEntity;
import dev.nar.projectrackr.entities.ProjetEntity;
import dev.nar.projectrackr.entities.TaskEntity;
import dev.nar.projectrackr.repositories.FonctionnaireRepository;
import dev.nar.projectrackr.service.CostService;
import dev.nar.projectrackr.service.ProjetService;
import dev.nar.projectrackr.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin("*")
public class TaskController {

    private final TaskService taskService;

    private final FonctionnaireRepository fonctionnaireRepository;
    private final ProjetService projetService;

    private final CostService costService;

    public TaskController(TaskService taskService, FonctionnaireRepository fonctionnaireRepository, ProjetService projetService, CostService costService) {
        this.taskService = taskService;
        this.fonctionnaireRepository = fonctionnaireRepository;
        this.projetService = projetService;
        this.costService = costService;
    }

    @PostMapping("/create_task")
    public TaskEntity createTask(@RequestBody TaskRequest taskRequest) {
        ProjetEntity projet = projetService.getProjectById(taskRequest.getProjectId());// Récupérer le projet associé à partir de l'identifiant fourni
        return taskService.createTask(projet, taskRequest.getTitle(),
                taskRequest.getDate_debut()
                , taskRequest.getDate_fin_estimee(), taskRequest.getDead_line(),
                taskRequest.getRespo_email(),taskRequest.getDescription(),
                taskRequest.getPriority(),taskRequest.getNum_ligne_code());
    }

    @PostMapping("/{taskId}/subtasks")
    public TaskEntity createSubTask(@PathVariable Integer taskId, @RequestBody TaskRequest taskRequest) {
        TaskEntity fatherTask = taskService.getTaskById(taskId);

        return taskService.createSubTask(fatherTask,
                taskRequest.getTitle(),
                taskRequest.getDate_debut(),
                taskRequest.getDate_fin_estimee(),
                taskRequest.getDead_line());
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
    public ResponseEntity<List<TaskEntity>> getAllTasksByProjectId(@PathVariable Integer projectId) {
        ProjetEntity projet = projetService.getProjectById(projectId); // Récupérer le projet associé à partir de l'identifiant fourni
        List<TaskEntity> tasks = taskService.findAllTasksByProjet(projet);

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/respo/{id}")
    public ResponseEntity<FonctionnaireEntity> getTaskRespo(@PathVariable Integer id){
        return new ResponseEntity<>(taskService.getTaskRespo(id),HttpStatus.OK);
    }

    @PutMapping("/{taskId}")
    public TaskEntity updateTask(@PathVariable Integer taskId, @RequestBody TaskRequest updatedTask) {
        TaskEntity task = taskService.getTaskById(taskId);
        task.setTitle(updatedTask.getTitle());
        task.setDate_debut(updatedTask.getDate_debut());
        task.setDate_fin_estime(updatedTask.getDate_fin_estimee());
        task.setDead_line(updatedTask.getDead_line());
        task.setRespo_tâche(fonctionnaireRepository.findByEmail(updatedTask.getRespo_email()));
        task.setDescription(updatedTask.description);
        task.setPriority(updatedTask.priority);
        task.setNum_ligne_code(updatedTask.num_ligne_code);
        if (!task.getNum_ligne_code().equals(updatedTask.num_ligne_code)) {
            costService.updateCost(task);
        }

        return taskService.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTaskById(@PathVariable Integer taskId) {
        taskService.deleteTaskById(taskId);
    }



    // Classe interne pour représenter une requête de création de tâche
    @Data
    @RequiredArgsConstructor
    @AllArgsConstructor
    private static class TaskRequest {
        private String title;
        private Date date_debut;
        private Date date_fin_estimee;
        private Date dead_line;
        private String respo_email;
        private String description;
        private String priority;
        private Double num_ligne_code;
        private Integer projectId;

        // Getters et setters
    }
}

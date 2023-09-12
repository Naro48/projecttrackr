package dev.nar.projectrackr.controllers;

import dev.nar.projectrackr.entities.CostEntity;
import dev.nar.projectrackr.entities.TaskEntity;
import dev.nar.projectrackr.repositories.CostRepository;
import dev.nar.projectrackr.repositories.TaskRepository;
import dev.nar.projectrackr.service.CostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.CodeSource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cost")
@CrossOrigin("*")
public class CostController {

    private final CostServiceImpl costService;

    private final CostRepository costRepository;

    private final TaskRepository taskRepository;
    public CostController(CostServiceImpl costService, CostRepository costRepository, TaskRepository taskRepository) {
        this.costService = costService;
        this.costRepository = costRepository;
        this.taskRepository = taskRepository;
    }

    @PostMapping("/create/{taskId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CostEntity> createCost(@PathVariable Integer taskId, @RequestBody List<String> ratings){
        TaskEntity task = taskRepository.findById(taskId).orElseThrow();

        CostEntity cost =  costService.createCost(task,ratings);
        return new ResponseEntity<>(cost, HttpStatus.OK);
    }





}


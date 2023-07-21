package dev.nar.projectrackr.controllers;

import dev.nar.projectrackr.entities.CostEntity;
import dev.nar.projectrackr.entities.TaskEntity;
import dev.nar.projectrackr.repositories.CostRepository;
import dev.nar.projectrackr.service.CostServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cost")
@CrossOrigin("*")
public class CostController {

    private final CostServiceImpl costService;

    private final CostRepository costRepository;
    public CostController(CostServiceImpl costService, CostRepository costRepository) {
        this.costService = costService;
        this.costRepository = costRepository;
    }

    @PostMapping("/cost/create")
    public CostEntity createCost(@RequestBody TaskEntity task, @PathVariable List<String> ratings){
        return costService.createCost(task,ratings);
    }

    @PostMapping("/cost/{costId}/update")
    public CostEntity updateCost(@PathVariable("costId") Integer costId, @PathVariable List<String> ratings,
                                 @PathVariable Double poids){

        CostEntity cost = costRepository.findById(costId).orElseThrow(() -> new RuntimeException("Ce coût est introuvable"));
        return costService.updateCost(cost,ratings,poids);
    }



}


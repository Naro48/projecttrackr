package dev.nar.projectrackr.service;

import dev.nar.projectrackr.entities.CostEntity;
import dev.nar.projectrackr.entities.CostFactorsEntity;
import dev.nar.projectrackr.entities.TaskEntity;

import java.util.List;

public interface CostService  {

    public CostEntity createCost(TaskEntity task, List<String> rating);

    public String chooseRatingOfEffortFactor();

    public CostEntity updateCost(TaskEntity task);
    
    public CostEntity findById(Integer id);





}

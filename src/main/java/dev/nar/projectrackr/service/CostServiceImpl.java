package dev.nar.projectrackr.service;

import dev.nar.projectrackr.CostFactorRes;
import dev.nar.projectrackr.TypeCOCOMO;
import dev.nar.projectrackr.entities.CostEntity;
import dev.nar.projectrackr.entities.TaskEntity;
import dev.nar.projectrackr.repositories.CostRepository;
import dev.nar.projectrackr.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.nar.projectrackr.entities.CostFactorsEntity.*;

@Service
public class CostServiceImpl implements CostService{

    private final CostRepository costRepository;

    private final TaskRepository taskRepository;

    public CostServiceImpl(CostRepository costRepository, TaskRepository taskRepository) {
        this.costRepository = costRepository;
        this.taskRepository = taskRepository;
    }


    @Override
    public CostEntity createCost(TaskEntity task, List<String> rating) {
        CostEntity cost = new CostEntity();
        cost.setTask(task);
        cost.setRating(rating);
        Double nlc = task.getNum_ligne_code();

        int index = 0;

        if (nlc<50){
            task.setTypeCOCOMO(TypeCOCOMO.ORGANIQUE);
            index = 0;
        }
        if (nlc<300 && nlc>50){
            task.setTypeCOCOMO(TypeCOCOMO.SEMI_DETACHED);
            index = 1;
        }
        if (nlc>300){
            task.setTypeCOCOMO(TypeCOCOMO.EMBEDDED);
            index = 2;
        }

        // Calcul de l'effort

        Double EM = 1.00;
        for (int i=0 ;i<15;i++){
            String ratingOfFactor = rating.get(i);



            if(CostFactorRes.poids.get(ratingOfFactor).get(i) == null) continue;

            EM *= CostFactorRes.poids.get(ratingOfFactor).get(i);
        }

        cost.setPoid(EM);

        Double effort = (CostFactorRes.A.get(index))*Math.pow(nlc,CostFactorRes.B.get(index))*EM; // jour-hommes

        String tdev= Double.toString(CostFactorRes.C*Math.pow(effort,CostFactorRes.D.get(index)));

        task.setEffort(Double.toString(effort)+ "Jour-Hommes");

        task.setTdev(tdev);

        taskRepository.save(task);
        return costRepository.save(cost);
    }

    @Override
    public String chooseRatingOfEffortFactor() {
        return null ;
    }

    @Override
    public CostEntity updateCost(CostEntity cost, List<String> ratings, Double poid) {
        cost.setPoid(poid);
        cost.setRating(ratings);
        return costRepository.save(cost);
    }
    
    @Override
    public CostEntity findById(Integer id){
        return costRepository.findById(id).orElseThrow(() -> new RuntimeException("Ce coût est introuvable"));
    }
}

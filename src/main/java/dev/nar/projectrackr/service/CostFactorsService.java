package dev.nar.projectrackr.service;

import dev.nar.projectrackr.entities.CostEntity;
import dev.nar.projectrackr.entities.CostFactorsEntity;

import java.util.List;
import java.util.Optional;

public interface CostFactorsService {


    public CostFactorsEntity createCostFactors(String title, float poids, List<CostEntity> costs);

    public CostFactorsEntity updateCostFactors(CostFactorsEntity costFactorsEntity,String newTitle
            ,float newPoids
            , List<CostEntity> newCosts);

    public Optional<CostFactorsEntity> findById(int id );

    public void deleteById(int id );

    public CostFactorsEntity findByTitle(String title);

    public List<CostFactorsEntity> searchByTitle(String title);

    public void deleteAll();

}

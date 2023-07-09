package dev.nar.projectrackr.service;

import dev.nar.projectrackr.entities.CostEntity;
import dev.nar.projectrackr.entities.CostFactorsEntity;
import dev.nar.projectrackr.repositories.CostFactorsRepository;

import java.util.List;
import java.util.Optional;

public class CostFactorsServiceImpl implements CostFactorsService{

    private final CostFactorsRepository costFactorsRepository;

    public CostFactorsServiceImpl(CostFactorsRepository costFactorsRepository) {
        this.costFactorsRepository = costFactorsRepository;
    }

    @Override
    public CostFactorsEntity createCostFactors(String title, float poids, List<CostEntity> costs) {
        CostFactorsEntity costFactorsEntity = new CostFactorsEntity();
        costFactorsEntity.setTitle(title);
        costFactorsEntity.setPoids(poids);
        costFactorsEntity.setCosts(costs);
        return costFactorsRepository.save(costFactorsEntity) ;
    }

    @Override
    public CostFactorsEntity updateCostFactors(CostFactorsEntity costFactorsEntity, String newTitle
            , float newPoids
            , List<CostEntity> newCosts) throws RuntimeException {

        Optional<CostFactorsEntity> optionalCostEntity = costFactorsRepository.findById(costFactorsEntity.getId());

        if (optionalCostEntity.isPresent()){

            costFactorsEntity.setTitle(newTitle);
            costFactorsEntity.setPoids(newPoids);
            costFactorsEntity.setCosts(newCosts);


            return costFactorsRepository.save(costFactorsEntity);
        }
        else {
            throw new RuntimeException("Le facteur de coût est introuvable");
        }
    }

    @Override
    public Optional<CostFactorsEntity> findById(int id) {
        return Optional.ofNullable(costFactorsRepository.findById(id).orElseThrow(() -> new RuntimeException("Le facteur de coût est introuvable")));
    }

    @Override
    public void deleteById(int id) {
        costFactorsRepository.deleteById(id);
    }

    @Override
    public CostFactorsEntity findByTitle(String title) {
        return costFactorsRepository.findByTitle(title);
    }

    @Override
    public List<CostFactorsEntity> searchByTitle(String title) {
        return costFactorsRepository.findByTitleIgnoreCase(title);
    }

    @Override
    public void deleteAll() {
        costFactorsRepository.deleteAll();
    }
}

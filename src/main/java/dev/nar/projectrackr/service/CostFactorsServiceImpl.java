package dev.nar.projectrackr.service;

import dev.nar.projectrackr.entities.CostEntity;
import dev.nar.projectrackr.entities.CostFactorsEntity;
import dev.nar.projectrackr.repositories.CostFactorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CostFactorsServiceImpl implements CostFactorsService{

    private final CostFactorsRepository costFactorsRepository;

    @Autowired
    public CostFactorsServiceImpl(CostFactorsRepository costFactorsRepository) {
        this.costFactorsRepository = costFactorsRepository;
    }

    @Override
    public Optional<CostFactorsEntity> findById(int id) {
        return Optional.ofNullable(costFactorsRepository.findById(id).orElseThrow(() -> new RuntimeException("Le facteur de coût est introuvable")));
    }


    @Override
    public CostFactorsEntity findByTitle(String title) {
        return costFactorsRepository.findByTitle(title);
    }

    @Override
    public List<CostFactorsEntity> searchByTitle(String title) {
        return costFactorsRepository.findByTitleIgnoreCase(title);
    }


}

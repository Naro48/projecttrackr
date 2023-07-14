package dev.nar.projectrackr.service;

import dev.nar.projectrackr.entities.CostEntity;
import dev.nar.projectrackr.entities.CostFactorsEntity;

import java.util.List;
import java.util.Optional;

public interface CostFactorsService {

    public Optional<CostFactorsEntity> findById(int id );

    public CostFactorsEntity findByTitle(String title);

    public List<CostFactorsEntity> searchByTitle(String title);


}

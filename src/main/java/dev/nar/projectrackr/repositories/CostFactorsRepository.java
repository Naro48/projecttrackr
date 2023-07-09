package dev.nar.projectrackr.repositories;

import dev.nar.projectrackr.entities.CostEntity;
import dev.nar.projectrackr.entities.CostFactorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CostFactorsRepository extends JpaRepository<CostFactorsEntity,Integer> {
    public List<CostFactorsEntity> findByTitleIgnoreCase(String title);

    public CostFactorsEntity findByTitle(String title );

    public void deleteById(int id );

    public void deleteAll();


}

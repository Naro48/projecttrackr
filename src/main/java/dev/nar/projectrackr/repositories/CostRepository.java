package dev.nar.projectrackr.repositories;

import dev.nar.projectrackr.entities.CostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CostRepository extends JpaRepository<CostEntity,Integer> {
    public Optional<CostEntity> findById(Integer id);
}

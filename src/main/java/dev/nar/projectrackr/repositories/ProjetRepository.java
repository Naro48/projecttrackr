package dev.nar.projectrackr.repositories;

import dev.nar.projectrackr.entities.ProjetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProjetRepository extends JpaRepository<ProjetEntity,Integer> {
    void deleteProjectById(Integer id);

    public List<ProjetEntity> findByTitleIgnoreCase(String title);

}

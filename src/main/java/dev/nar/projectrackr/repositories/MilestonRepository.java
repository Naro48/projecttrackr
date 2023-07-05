package dev.nar.projectrackr.repositories;

import dev.nar.projectrackr.entities.MilestonEntity;
import dev.nar.projectrackr.entities.ProjetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MilestonRepository extends JpaRepository<MilestonEntity,Integer> {

    public List<MilestonEntity> findByTypeIgnoreCase(String type);

    public void deleteById(int id);

    public void deleteByProjet(ProjetEntity projet);



}

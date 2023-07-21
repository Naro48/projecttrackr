package dev.nar.projectrackr.repositories;

import dev.nar.projectrackr.entities.FonctionnaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FonctionnaireRepository extends JpaRepository<FonctionnaireEntity,Integer> {


    Optional<FonctionnaireEntity> findByEmail(String email);




}

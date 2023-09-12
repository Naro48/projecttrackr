package dev.nar.projectrackr.repositories;

import dev.nar.projectrackr.entities.FonctionnaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FonctionnaireRepository extends JpaRepository<FonctionnaireEntity,Integer> {


    FonctionnaireEntity findByEmail(String email);




}

package dev.nar.projectrackr.repositories;

import dev.nar.projectrackr.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Integer> {


}

package dev.nar.projectrackr.repositories;

import dev.nar.projectrackr.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity,Integer> {
    public List<TaskEntity> findByTitleContainingIgnoredCase(String keyword);

    public List<TaskEntity> getTasksByProjectId(int projectId);
}

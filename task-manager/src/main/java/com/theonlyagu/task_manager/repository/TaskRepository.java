package com.theonlyagu.task_manager.repository;

import com.theonlyagu.task_manager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId); // Custom method to find tasks by user ID { foreign key }

    void deleteByUserId(Long userID);

    Object deleteByTaskIdAndUserId(Long taskId, Long userId);
}

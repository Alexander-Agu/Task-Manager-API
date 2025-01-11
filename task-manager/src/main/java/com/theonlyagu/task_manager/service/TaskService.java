package com.theonlyagu.task_manager.service;

import com.theonlyagu.task_manager.entity.Task;
import com.theonlyagu.task_manager.repository.TaskRepository;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;


    // Gets all tasks from the database
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }


    // Finds tasks by the user foreign key
    public List<Task> getUserTask(Long userId){
        return taskRepository.findByUserId(userId);
    }
}

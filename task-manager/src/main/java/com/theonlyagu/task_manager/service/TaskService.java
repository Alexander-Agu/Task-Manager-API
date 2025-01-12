package com.theonlyagu.task_manager.service;

import com.theonlyagu.task_manager.entity.Task;
import com.theonlyagu.task_manager.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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


    // Deletes Task by ID
    @Transactional
    public void deleteTask(Long userId, Long taskId){
        boolean taskExists = taskRepository.existsById(taskId);
        if (taskExists) {
            System.out.println(taskRepository.deleteByTaskIdAndUserId(taskId, userId));
            taskRepository.deleteById(taskId);
        } else{
            throw new IllegalStateException("Task does not exist");
        }
    }


    // Updates the task
    public void updateTask(Long userId, Long taskId, Task task){
        Task taskData = taskRepository.findById(taskId).get();

        if (Objects.nonNull(task.getTask()) && taskData.getUser().equals(userId)){
            taskData.setTask(task.getTask());
            taskRepository.save(taskData);
        } else {
            throw new IllegalStateException("Task does not exist");
        }
    }

    // Updates the due date
    public void updateDueDate(Long userId, Long taskId, Task task){
        Task taskData = taskRepository.findById(taskId).get();

        if (Objects.nonNull(task.getDueDate()) && taskData.getUser().equals(userId)){
            taskData.setDueDate(task.getDueDate());
            taskRepository.save(taskData);
        } else {
            throw new IllegalStateException("Due Date has to exist to be updated");
        }


    }
}

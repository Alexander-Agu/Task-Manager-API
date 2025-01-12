package com.theonlyagu.task_manager.controller;

import com.theonlyagu.task_manager.entity.Task;
import com.theonlyagu.task_manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;


    // Gets all the differrent users tasks from the DB Table
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }


    // Gets Tasks that are specific to 1 user by their ID
    @GetMapping("/user/{user_id}")
    public List<Task> getTask(@PathVariable Long user_id){
        return taskService.getUserTask(user_id);
    }


    // Suppose to delete the task by taskId and UserId
    @DeleteMapping("/delete/{userId}/{taskId}")
    public void deleteTask(@PathVariable("userId") Long userId, @PathVariable("taskId") Long taskId){
        taskService.deleteTask(userId, taskId);
    }


    // Updates the task
    @PutMapping("/updateTask/{userId}/{taskId}")
    public void updateTask(
            @PathVariable("userId") Long userId,
            @PathVariable("taskId") Long taskId,
            @RequestBody Task task
    ){
        taskService.updateTask(userId, taskId, task);
    }

    // Updates the Due date
    @PutMapping("/updateDueDate/{userId}/{taskId}")
    public void updateDueDate(
            @PathVariable("userId") Long userId,
            @PathVariable("taskId") Long taskId,
            @RequestBody Task task
    ){
        taskService.updateDueDate(userId, taskId, task);
    }


}

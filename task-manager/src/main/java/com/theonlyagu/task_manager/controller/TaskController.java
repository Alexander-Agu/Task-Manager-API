package com.theonlyagu.task_manager.controller;

import com.theonlyagu.task_manager.entity.Task;
import com.theonlyagu.task_manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

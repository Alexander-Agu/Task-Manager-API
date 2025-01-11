package com.theonlyagu.task_manager.controller;

import com.theonlyagu.task_manager.entity.Task;
import com.theonlyagu.task_manager.entity.User;
import com.theonlyagu.task_manager.repository.UserRepository;
import com.theonlyagu.task_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( path = "taskmanager" )
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;


    // Login => Gets user information when a request is made with an email
    @GetMapping("/getUser")
    public Optional<User> getUsers(@RequestBody User user){
        return userService.getUserByMail(user.getEmail());
    }


    // Registers a new user to the DB by posting their data
    @PostMapping("/register")
    public void postUsers(@RequestBody User user){
        userService.saveUser(user);
    }


    // Deletes account by user_id
    @DeleteMapping(path = "/{userId}")
    public void deleteUser(@PathVariable("userId") Long id){
        userService.deleteAccount(id);
    }

    // Saves task to the DB Table
    @PostMapping("/users/{userId}/tasks")
    public Task postTask(@PathVariable Long userId, @RequestBody Task task) {
        return userService.createTask(userId, task);
    }
}

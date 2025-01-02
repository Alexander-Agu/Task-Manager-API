package com.theonlyagu.task_manager.controller;

import com.theonlyagu.task_manager.entity.User;
import com.theonlyagu.task_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "taskmanager")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("getUsers")
    public List<User> getUsers(){
        return userService.fetchUsers();
    }


    @PostMapping("register")
    public void postUsers(@RequestBody User user){
        userService.saveUser(user);
    }
}

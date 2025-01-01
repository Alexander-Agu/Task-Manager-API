package com.theonlyagu.task_manager.controller;

import com.theonlyagu.task_manager.entity.User;
import com.theonlyagu.task_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "taskmanager")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("getUsers")
    public List<User> getUsers(){
        return userService.fetchUsers();
    }
}

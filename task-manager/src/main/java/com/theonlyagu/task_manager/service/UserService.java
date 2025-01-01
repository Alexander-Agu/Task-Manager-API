package com.theonlyagu.task_manager.service;

import com.theonlyagu.task_manager.entity.User;
import com.theonlyagu.task_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> fetchUsers(){
        return userRepository.findAll();
    }

}

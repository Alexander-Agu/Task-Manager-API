package com.theonlyagu.task_manager.service;

import com.theonlyagu.task_manager.entity.Task;
import com.theonlyagu.task_manager.entity.User;
import com.theonlyagu.task_manager.repository.TaskRepository;
import com.theonlyagu.task_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;


    // Fetches all users in the DB
    public List<User> fetchUsers(){
        return userRepository.findAll();
    }


    // Finds users by email
    public Optional<User> getUserByMail(String mail){
        return userRepository.findUserByEmail(mail);
    }


    // Allows users to only post data with a unique email
    public void saveUser(User user){
        Optional<User> findbyMail = userRepository.findUserByEmail(user.getEmail());
        if(!findbyMail.isPresent()){
            userRepository.save(user);
        } else {
            throw new IllegalStateException("Email already exists. Create a unique email");
        }
    }


    // Makes sure a user has an account to create a task
    public Task createTask(Long userId, Task task) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get(); // Gets the Users object
            task.setUser(user); // Sets user foreign key
            return taskRepository.save(task);
        } else {
            throw new RuntimeException("User not found");
        }
    }


    // Lets users delete their account and their tasks
    public void deleteAccount(Long id, Long user_id){
        boolean accountExist = userRepository.existsById(id);
        if(accountExist){
            userRepository.deleteById(id);
            taskRepository.deleteByUserId(user_id);
        } else {
            throw new IllegalStateException("This account does not exist");
        }

    }

}

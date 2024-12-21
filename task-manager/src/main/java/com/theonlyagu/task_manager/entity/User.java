package com.theonlyagu.task_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private Long id;
    private String name;
    private String accupation;
    private String email;
    private String password;

    public User(String password, String email, String accupation, String name, Long id) {
        this.password = password;
        this.email = email;
        this.accupation = accupation;
        this.name = name;
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccupation() {
        return accupation;
    }

    public void setAccupation(String accupation) {
        this.accupation = accupation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

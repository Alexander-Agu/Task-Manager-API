package com.theonlyagu.task_manager.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(
        name = "users",
        uniqueConstraints = @UniqueConstraint( // Making sure the email column is unique
                name = "emailid_unique",
                columnNames = "email_address"
        )
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "id_sequence", allocationSize = 1)
    private Long id;
    private String name;
    private String occupation;

    @Column(name = "email_address", nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Task> task;

    public User(){

    } 

    public User(String password, String email, String occupation, String name, Long id) {
        this.password = password;
        this.email = email;
        this.occupation = occupation;
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return occupation;
    }

    public void setAccupation(String accupation) {
        this.occupation = accupation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

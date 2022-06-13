package com.Auther.security_system.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String username;
    private String password;
    private String email;


    public User (User user){
        this.username=user.getUsername();
        this.password=user.getPassword();
        this.email=user.getEmail();
        this.id=user.getId();

    }
    public User(){

    }
}

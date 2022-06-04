package com.example.backend.controller;

import com.example.backend.entity.UserR;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostConstruct
    public void initRolesAndUsers(){
        userService.initRolesAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public UserR registerNewUser(@RequestBody UserR userR){
        return userService.registerNewUser(userR);
    }

    @GetMapping({"/forAdmin"})
    public String forAdmin(){
        return "This URL is only accessible to admin";
    }

    @GetMapping({"/forUser"})
    public String forUser(){
        return "This URL is only accessible to the user";
    }

}

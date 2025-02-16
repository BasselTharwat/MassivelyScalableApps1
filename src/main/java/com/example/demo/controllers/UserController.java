package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();

    }

    @GetMapping(path = "/{id}")
    public User getUserbyId(@PathVariable String id){
        return userService.getUserById(id);

    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping(path = "/hello")
    public String testController(){
        return "Hello from user controller";
    }


}

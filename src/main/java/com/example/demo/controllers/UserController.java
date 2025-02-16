package com.example.demo.controllers;

import com.example.demo.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {


    @GetMapping
    public List<User> getUsers(){
        User user1 = new User(24, "bro", "hhh@gmail.com");
        return List.of(user1);
    }

    @GetMapping(path = "/{id}")
    public User getUserbyId(@PathVariable String id){
        return new User(id,"broooooooo", 24, "hhh@gmail.com");

    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return user;
    }

    @GetMapping(path = "/hello")
    public String testController(){
        return "Hello from user controller";
    }


}

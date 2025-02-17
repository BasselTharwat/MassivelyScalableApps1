package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/welcome")
public class WelcomeController {

    @Value("${Name:Bassel Tharwat}")
    String name;

    @GetMapping
    public String welcome(){
        return "Welcome to ACL, " + name;
    }


}

package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(String id){
        Optional<User> optional = userRepository.findById(id);
        if(optional.isEmpty()){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
        }
        return optional.get();
    }

    public User createUser(User user){
        return userRepository.save(user);
      }

}

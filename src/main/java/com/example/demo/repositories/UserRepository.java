package com.example.demo.repositories;

import com.example.demo.models.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {

    public List<User> findAll() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ClassPathResource resource = new ClassPathResource("users.json");
            InputStream inputStream = resource.getInputStream();
            List<User> users = objectMapper.readValue(inputStream,
                    new TypeReference<List<User>>() {});
            return users;
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "File not found: " + e.getMessage());
        }
    }


    public Optional<User> findById(String id){
        try{
            return findAll().stream()
                    .filter(user -> user.getId().equals(id))
                    .findFirst();

        }catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to read users.json");
        }
    }

    public User save(User user){
        user.setId(UUID.randomUUID().toString());
        return user;
    }






}

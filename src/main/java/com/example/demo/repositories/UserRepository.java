package com.example.demo.repositories;

import com.example.demo.models.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    public List<User> findAll(){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String FILE_PATH = "src/main/resources/users.json";
            File file = new ClassPathResource("users.json").getFile();
            List<User> users = objectMapper.readValue(file, new TypeReference<List<User>>() {});
            return users;
        }catch (Exception _){

        }

        return List.of();
    }

    public Optional<User> findById(String id){
        try{
            return findAll().stream()
                    .filter(user -> user.getId().equals(id))
                    .findFirst();

        }catch (Exception _){

        }
        return null;
    }

    // fadel save user




}

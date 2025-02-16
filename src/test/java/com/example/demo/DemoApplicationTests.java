package com.example.demo;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
	}

	@Test
	void createUser_withValidInput_shouldReturnSameNameAndEmail(){
		// Arrange
		User newUser = new User(30, "Bob", "bob@java.com");

		// Act
		User savedUser = userService.createUser(newUser);

		// Assert
		assertEquals(savedUser.getName(),newUser.getName(), "Name is not the same");
		assertEquals(savedUser.getEmail(), newUser.getEmail(), "Email is not the same");

	}


}

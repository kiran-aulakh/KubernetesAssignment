package org.nagarro.microservices.userservice.controller;

import org.nagarro.microservices.userservice.entities.User;
import org.nagarro.microservices.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserMicroserviceController {

	@Autowired
	UserService userService;

	@GetMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	User getUser(@PathVariable(value = "id") int id) {
		System.out.println(" Getting details for user with id " + id);
		return userService.getUserData(id);
	}
}

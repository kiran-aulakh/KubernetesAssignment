package org.nagarro.microservices.userservice.controller;

import javax.annotation.Resource;

import org.nagarro.microservices.userservice.entities.UserModel;
import org.nagarro.microservices.userservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserMicroserviceController {

	@Resource
	UserService userService;

	@GetMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	UserModel getUser(@PathVariable(value = "id") int id) {
		return userService.getUserData(id);
	}
}

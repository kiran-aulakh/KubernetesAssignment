package org.nagarro.microservices.userservice.service;

import org.nagarro.microservices.userservice.entities.User;

public interface UserService {

	User getUserData(final int id);
}

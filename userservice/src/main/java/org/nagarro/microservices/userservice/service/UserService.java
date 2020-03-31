package org.nagarro.microservices.userservice.service;

import org.nagarro.microservices.userservice.entities.UserModel;

public interface UserService {

	UserModel getUserData(final int id);
}

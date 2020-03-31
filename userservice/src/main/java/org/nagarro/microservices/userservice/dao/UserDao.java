package org.nagarro.microservices.userservice.dao;

import org.nagarro.microservices.userservice.entities.UserModel;

public interface UserDao {

	UserModel getUserData(final int id);
}

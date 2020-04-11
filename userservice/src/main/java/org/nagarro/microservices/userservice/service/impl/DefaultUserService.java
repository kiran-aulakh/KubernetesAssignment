package org.nagarro.microservices.userservice.service.impl;

import java.util.Optional;

import org.nagarro.microservices.userservice.dao.UserDao;
import org.nagarro.microservices.userservice.entities.User;
import org.nagarro.microservices.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public User getUserData(int id) {
		Optional<User> userWithId = userDao.findById(id);
		if (userWithId.isPresent()) {
			return userWithId.get();
		}
		return null;
	}
}

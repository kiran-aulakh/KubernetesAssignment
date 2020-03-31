package org.nagarro.microservices.userservice.service.impl;

import javax.annotation.Resource;

import org.nagarro.microservices.userservice.dao.UserDao;
import org.nagarro.microservices.userservice.entities.UserModel;
import org.nagarro.microservices.userservice.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {

	@Resource
	UserDao userDao;

	@Override
	public UserModel getUserData(int id) {
		return userDao.getUserData(id);
	}

}

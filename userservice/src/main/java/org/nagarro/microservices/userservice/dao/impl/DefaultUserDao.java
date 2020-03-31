package org.nagarro.microservices.userservice.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.nagarro.microservices.userservice.dao.UserDao;
import org.nagarro.microservices.userservice.entities.UserModel;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultUserDao implements UserDao {

	@Override
	public UserModel getUserData(int id) {
		Optional<UserModel> user = getAllUsers().stream().filter(usr -> usr.getId() == id).findAny();
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

	private List<UserModel> getAllUsers() {
		List<UserModel> userList = new ArrayList<>();
		userList.add(new UserModel(1, "John", "23", "john@gmail.com"));
		userList.add(new UserModel(2, "Bob", "24", "bob@gmail.com"));
		userList.add(new UserModel(3, "Max", "25", "max@gmail.com"));
		userList.add(new UserModel(4, "Galot", "26", "galot@gmail.com"));
		userList.add(new UserModel(5, "Alexa", "27", "alexa@gmail.com"));
		return userList;
	}
}

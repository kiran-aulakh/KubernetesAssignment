package org.nagarro.microservices.userservice.dao;

import org.nagarro.microservices.userservice.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {

}

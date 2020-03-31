package org.nagarro.microservices.aggregatorservice.entities;

import java.util.List;

public class Aggregator {

	UserModel userDetails;
	List<Order> orders;
	
	
	public Aggregator() {
		super();
	}


	public Aggregator(UserModel user, List<Order> order) {
		super();
		this.userDetails = user;
		this.orders = order;
	}


	public UserModel getUserDetails() {
		return userDetails;
	}


	public void setUserDetails(UserModel userDetails) {
		this.userDetails = userDetails;
	}


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}

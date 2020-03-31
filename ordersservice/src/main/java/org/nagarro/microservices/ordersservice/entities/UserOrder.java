package org.nagarro.microservices.ordersservice.entities;

public class UserOrder {

	int userId;
	Order orders;

	public UserOrder() {
		super();
	}

	public UserOrder(int userId, Order orders) {
		super();
		this.userId = userId;
		this.orders = orders;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

}

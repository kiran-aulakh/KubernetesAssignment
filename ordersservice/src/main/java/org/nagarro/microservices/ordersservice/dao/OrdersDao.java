package org.nagarro.microservices.ordersservice.dao;

import java.util.List;

import org.nagarro.microservices.ordersservice.entities.Order;

public interface OrdersDao {

	List<Order> getOrdersForUser(final int userId);
}

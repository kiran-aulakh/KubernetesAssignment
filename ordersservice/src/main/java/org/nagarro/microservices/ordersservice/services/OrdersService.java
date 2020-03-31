package org.nagarro.microservices.ordersservice.services;

import java.util.List;

import org.nagarro.microservices.ordersservice.entities.Order;

public interface OrdersService {

	List<Order> getOrdersForUser(final int userId);
}

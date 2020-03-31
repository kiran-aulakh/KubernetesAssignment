package org.nagarro.microservices.ordersservice.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.nagarro.microservices.ordersservice.dao.OrdersDao;
import org.nagarro.microservices.ordersservice.entities.Order;
import org.nagarro.microservices.ordersservice.services.OrdersService;
import org.springframework.stereotype.Service;

@Service
public class DefaultOrdersService implements OrdersService {

	@Resource
	OrdersDao orderDao;

	@Override
	public List<Order> getOrdersForUser(int userId) {
		return orderDao.getOrdersForUser(userId);
	}

}

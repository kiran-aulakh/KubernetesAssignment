package org.nagarro.microservices.ordersservice.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.nagarro.microservices.ordersservice.dao.OrdersDao;
import org.nagarro.microservices.ordersservice.entities.Order;
import org.nagarro.microservices.ordersservice.entities.UserOrder;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultOrdersDao implements OrdersDao {

	@Override
	public List<Order> getOrdersForUser(int userId) {
		List<UserOrder> orders = getAllOrders().stream().filter(order -> userId == order.getUserId())
				.collect(Collectors.toList());
		List<Order> ordersForUser = new ArrayList<Order>();
		orders.forEach(order -> {
			ordersForUser.add(order.getOrders());
		});

		return ordersForUser;
	}

	List<UserOrder> getAllOrders() {
		List<UserOrder> orders = new ArrayList<>();
		orders.add(new UserOrder(1, new Order(1, 250, "14-Apr-2020")));
		orders.add(new UserOrder(1, new Order(2, 450, "14-Apr-2020")));
		orders.add(new UserOrder(2, new Order(3, 550, "14-Apr-2020")));
		orders.add(new UserOrder(2, new Order(4, 650, "14-Apr-2020")));
		orders.add(new UserOrder(2, new Order(5, 750, "14-Apr-2020")));
		orders.add(new UserOrder(3, new Order(6, 850, "14-Apr-2020")));
		orders.add(new UserOrder(3, new Order(7, 950, "14-Apr-2020")));
		orders.add(new UserOrder(4, new Order(8, 250, "14-Apr-2020")));
		orders.add(new UserOrder(4, new Order(9, 150, "14-Apr-2020")));
		orders.add(new UserOrder(5, new Order(10, 1250, "14-Apr-2020")));
		orders.add(new UserOrder(5, new Order(11, 2150, "14-Apr-2020")));
		return orders;
	}
}

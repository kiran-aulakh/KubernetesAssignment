package org.nagarro.microservices.ordersservice.controller;

import java.util.List;

import javax.annotation.Resource;

import org.nagarro.microservices.ordersservice.entities.Order;
import org.nagarro.microservices.ordersservice.services.OrdersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderMicroserviceController {

	@Resource
	OrdersService orderService;

	@GetMapping(path = "/{userId}", consumes = "application/json", produces = "application/json")
	List<Order> getOrdersForUser(@PathVariable(value = "userId") final int userId) {
		return orderService.getOrdersForUser(userId);
	}
}

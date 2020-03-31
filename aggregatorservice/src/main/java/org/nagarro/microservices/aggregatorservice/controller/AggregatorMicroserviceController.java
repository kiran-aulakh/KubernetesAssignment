package org.nagarro.microservices.aggregatorservice.controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.nagarro.microservices.aggregatorservice.entities.Aggregator;
import org.nagarro.microservices.aggregatorservice.entities.Order;
import org.nagarro.microservices.aggregatorservice.entities.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/orderdetails")
public class AggregatorMicroserviceController {

	@Value(value = "${user.service.url}")
	String usersUrl;

	@Value(value = "${orders.service.url}")
	String ordersUrl;

	@Resource(name = "restTemp")
	private RestTemplate restTemplate;

	@GetMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public Aggregator getOrderDetailsforUser(@PathVariable(value = "id") int id){
		String usersServiceUrl = System.getenv("USER_URL");
		String ordersServiceUrl = System.getenv("ORDERS_URL");
		String userServiceRedirectUrl = usersUrl;
		String ordersServiceRedirectUrl = ordersUrl;
		Aggregator obj = new Aggregator();
		if (!StringUtils.isEmpty(usersServiceUrl)) {
			userServiceRedirectUrl = usersServiceUrl;
		}
		if (!StringUtils.isEmpty(ordersUrl)) {
			ordersServiceRedirectUrl = ordersServiceUrl;
		}
		userServiceRedirectUrl = userServiceRedirectUrl + "/user/" + id;
		ordersServiceRedirectUrl = ordersServiceRedirectUrl + "/orders/" + id;
		System.out.println("userServiceRedirectUrl " + userServiceRedirectUrl);
		System.out.println("ordersServiceRedirectUrl " + ordersServiceRedirectUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<UserModel> responseEntityForUser = restTemplate.exchange(userServiceRedirectUrl, HttpMethod.GET,
				entity, UserModel.class);
		ResponseEntity<List> responseEntityForOrders = restTemplate.exchange(ordersServiceRedirectUrl, HttpMethod.GET,
				entity, List.class);
		if (Objects.nonNull(responseEntityForOrders.getBody()) && Objects.nonNull(responseEntityForUser.getBody())) {
			obj.setUserDetails(responseEntityForUser.getBody());
			obj.setOrders(responseEntityForOrders.getBody());
		}
		return obj;

	}
}

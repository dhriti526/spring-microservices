package com.dhriti.orderservice.controller;

import java.util.List;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhriti.orderservice.orderDTO.OrderLineItemsDTO;
import com.dhriti.orderservice.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@PostMapping
	@CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
	private String orderRequest(@RequestBody List<OrderLineItemsDTO> orderLineItemsDTO)	{
		orderService.createOrderRequest(orderLineItemsDTO);
		return "order placed successfully";
	}

	public String fallbackMethod(List<OrderLineItemsDTO> orderLineItemsDTO, RuntimeException runtimeException){
		return "Oops! Something went wrong, please try after some time";
	}
}

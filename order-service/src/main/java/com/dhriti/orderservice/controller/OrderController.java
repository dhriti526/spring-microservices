package com.dhriti.orderservice.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
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
@TimeLimiter(name = "inventory")
@Retry(name = "inventory")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@PostMapping
	@CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
	private CompletableFuture<String> orderRequest(@RequestBody List<OrderLineItemsDTO> orderLineItemsDTO)	{
		return CompletableFuture.supplyAsync(()->orderService.createOrderRequest(orderLineItemsDTO));
	}

	public CompletableFuture<String> fallbackMethod(List<OrderLineItemsDTO> orderLineItemsDTO, RuntimeException runtimeException){
		return CompletableFuture.supplyAsync(()->"Oops! Something went wrong, please try after some time");
	}
}

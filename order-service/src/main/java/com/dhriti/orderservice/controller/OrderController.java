package com.dhriti.orderservice.controller;

import java.util.List;

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
	private ResponseEntity<String> orderRequest(@RequestBody List<OrderLineItemsDTO> orderLineItemsDTO)	{
		orderService.createOrderRequest(orderLineItemsDTO);
		return new ResponseEntity<String>("order placed successfully", HttpStatus.CREATED);
	}
}

package com.dhriti.orderservice.service;

import java.util.Arrays;
import java.util.List;

import com.dhriti.orderservice.config.WebClientConfig;
import com.dhriti.orderservice.orderDTO.InventoryResponse;
import event.OrderPlacedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhriti.orderservice.mapper.OrderLineItemsMapper;
import com.dhriti.orderservice.model.Order;
import com.dhriti.orderservice.model.OrderLineItems;
import com.dhriti.orderservice.orderDTO.OrderLineItemsDTO;
import com.dhriti.orderservice.repository.OrderRepository;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderLineItemsMapper orderLineItemsMapper;

	private final WebClient.Builder webClientBuilder;

	private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

	private final OrderRepository orderRepository;
	
//	public OrderService(OrderLineItemsMapper orderLineItemsMapper, OrderRepository orderRepository) {
//		this.orderLineItemsMapper = orderLineItemsMapper;
//		this.orderRepository = orderRepository;
//	}
	
	public String createOrderRequest(List<OrderLineItemsDTO> orderLineItemsDTO) {
		List<OrderLineItems> orderLineItemsList = orderLineItemsMapper.OrderLineItemstEntityTOOrderLineItemsDTO(orderLineItemsDTO);
		Order order = new Order();
		order.setOrderLineItems(orderLineItemsList);
		// call Inventory service and place order if product is in stock
		List<String> skuCode = orderLineItemsList.stream().map(orderLineItem -> orderLineItem.getSkuCode()).toList();
		InventoryResponse[] result;
		result = webClientBuilder.build().get().
				uri("http://inventory-service/api/inventory", uriBuilder -> uriBuilder.queryParam("sku-code",skuCode).build())
						.retrieve()
								.bodyToMono(InventoryResponse[].class)
				.block();
		boolean allProductsInStok = Arrays.stream(result).allMatch(inventoryResponse -> inventoryResponse.isInStock());
		if(Boolean.TRUE.equals(allProductsInStok))	{
			orderRepository.save(order);
			kafkaTemplate.send("notificationTopic", new OrderPlacedEvent(order.getOrderNumb()));
			return "Order places successfully!";
		} else {
			throw new IllegalArgumentException("Product is not in stock");

		}

//		orderRepository.save(order);
	}
	
}

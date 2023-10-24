package com.dhriti.orderservice.mapper;

import java.util.List;

import org.hibernate.annotations.Source;
import org.hibernate.annotations.Target;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dhriti.orderservice.model.Order;
import com.dhriti.orderservice.model.OrderLineItems;
import com.dhriti.orderservice.orderDTO.OrderLineItemsDTO;

@Mapper(componentModel = "spring", uses = {})
public interface OrderLineItemsMapper {

	List<OrderLineItems> OrderLineItemstEntityTOOrderLineItemsDTO(List<OrderLineItemsDTO> OrderLineItemsDTO);
}

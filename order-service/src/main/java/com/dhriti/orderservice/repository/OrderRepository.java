package com.dhriti.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhriti.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

}

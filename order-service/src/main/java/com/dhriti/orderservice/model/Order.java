package com.dhriti.orderservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "t_orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String orderNumber;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderLineItems> orderLineItems;
	
	@Override
	public int hashCode() {
		return Objects.hash(id, orderLineItems, orderNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id) && Objects.equals(orderLineItems, other.orderLineItems)
				&& Objects.equals(orderNumber, other.orderNumber);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumb() {
		return orderNumber;
	}

	public void setOrderNumb(String orderNumb) {
		this.orderNumber = orderNumb;
	}

	public List<OrderLineItems> getOrderLineItems() {
		return orderLineItems;
	}

	public void setOrderLineItems(List<OrderLineItems> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}

	public Order(Long id, String orderNumb, List<OrderLineItems> orderLineItems) {
		super();
		this.id = id;
		this.orderNumber = orderNumb;
		this.orderLineItems = orderLineItems;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	
}

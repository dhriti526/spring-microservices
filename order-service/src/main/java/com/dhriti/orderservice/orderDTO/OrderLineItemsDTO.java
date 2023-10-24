package com.dhriti.orderservice.orderDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import com.dhriti.orderservice.model.OrderLineItems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class OrderLineItemsDTO {
	
	private String skuCode;
	private BigDecimal price;
	private Integer quantity;
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderLineItemsDTO [skuCode=" + skuCode + ", price=" + price + ", quantity=" + quantity + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(price, quantity, skuCode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLineItemsDTO other = (OrderLineItemsDTO) obj;
		return Objects.equals(price, other.price) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(skuCode, other.skuCode);
	}  

}

package com.dhriti.inventoryservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhriti.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.Query;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

//	public Optional<Inventory> findBySkuCode(String skuCode);

//	@Query("Select * from Inventory i WHERE i.skuCode == skuCode")
	public List<Inventory> findBySkuCodeIn(List<String> skuCode);
}

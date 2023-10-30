package com.dhriti.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.dhriti.inventoryservice.model.Inventory;
import com.dhriti.inventoryservice.repository.InventoryRepository;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository)	{
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("azicus-500 tab");
			inventory.setQuantity(100);
			
			Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("azicus-500 tab_20mg");
			inventory2.setQuantity(0);
			
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory2);
		};
	}

}

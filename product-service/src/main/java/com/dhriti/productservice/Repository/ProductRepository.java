package com.dhriti.productservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhriti.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}

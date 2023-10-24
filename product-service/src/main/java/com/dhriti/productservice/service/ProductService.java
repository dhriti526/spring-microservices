package com.dhriti.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.dhriti.productservice.Dto.ProductDTO;
import com.dhriti.productservice.Repository.ProductRepository;
import com.dhriti.productservice.mapper.ProductMapper;
import com.dhriti.productservice.model.Product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
public class ProductService {
	
//	@Autowired
//	private ProductMapper productMapper;
	
	@Autowired
	private ProductRepository productRepository;
	
	public void createProduct(ProductDTO productRequest)	{
//		Product product = Product.builder()
//				.name(productRequest.getName())
//				.description(productRequest.getDescription())
//				.price(productRequest.getName());
//		Product product = new Product();
//		product.svc
		Product product = new Product(productRequest.getName(), productRequest.getDescription(),
				productRequest.getPrice());
		productRepository.save(product);
//		Logger.info("");

	}
	
	public List<ProductDTO> getProduct()	{
		List<Product> productList = productRepository.findAll();
		List<ProductDTO> ProductList = 
				productList.stream(
//			ProductDTO productDTO = new ProductDTO(a.getId(),a.getName(),a.getDescription(),a.getPrice());
		).map(a->{return new ProductDTO(a.getId(),a.getName(),a.getDescription(),a.getPrice());
		}).toList();
		return ProductList;
	}
}

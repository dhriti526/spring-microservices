package com.dhriti.productservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dhriti.productservice.Dto.ProductDTO;
import com.dhriti.productservice.service.ProductService;

@RestController
@RequestMapping(value="/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody ProductDTO productRequest)	{
		productService.createProduct(productRequest);
		
	}
	
@GetMapping()
public ResponseEntity<List<ProductDTO>> getProduct()	{
	List<ProductDTO> productDTO = productService.getProduct();
	return new ResponseEntity<>(productDTO, HttpStatus.OK);
	}

}

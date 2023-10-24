package com.dhriti.productservice.mapper;

import java.util.List;

import org.mapstruct.Mapper;
//import org.springframework.stereotype.Component;

import com.dhriti.productservice.Dto.ProductDTO;
import com.dhriti.productservice.model.Product;

@Mapper(componentModel = "Spring", uses = {})
//@Component
public interface ProductMapper {
	
	Product toEntity(ProductDTO ProductRequest);
	
	List<ProductDTO> toDTO(List<Product> product);

}

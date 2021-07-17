package com.shopwatch.api.service;

import java.util.List;

import com.shopwatch.api.dto.ProductDTO;
import com.shopwatch.api.entity.Product;

public interface ProductService {
	
	Product findById(int id);
	
	List<Product> findAllProduct();
	
	Product createProduct(ProductDTO productDTO);
	
	Product updateProduct(ProductDTO productDTO);
	
	boolean deleteProductById(int id);
}

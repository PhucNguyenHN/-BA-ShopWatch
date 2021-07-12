package com.shopwatch.api.service;

import java.util.List;

import com.shopwatch.api.entity.Product;

public interface ProductService {
	
	Product findById(int id);
	
	List<Product> findAllProduct();
	
	Product updateTypeWatch(Product product);
	
	boolean deleteProductById(int id);
}

package com.shopwatch.api.service;

import java.util.List;

import com.shopwatch.api.controller.result.ProductResult;
import com.shopwatch.api.dto.ProductDTO;
import com.shopwatch.api.entity.Product;

public interface ProductService {
	
	Product findById(int id);
	
	List<ProductResult> findAllProduct();
	
	Product createProduct(ProductDTO productDTO);
	
	Product updateProduct(ProductDTO productDTO);
	
	boolean deleteProductById(int id);
}

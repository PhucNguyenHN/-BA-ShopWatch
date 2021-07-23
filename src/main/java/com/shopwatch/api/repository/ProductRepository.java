package com.shopwatch.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopwatch.api.controller.result.ProductResult;
import com.shopwatch.api.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findById(int id);
	
	Product findByNameAndStatus(String name, boolean status);
	
	@Query(value = "select * from product p where p.status = ?1", nativeQuery = true)
	List<Product> customSelectAllProduct(boolean status);
	
	@Query(value = "select name, price_old, price_new, images, color_id, brand_id, create_at from product p where p.status = ?1", nativeQuery = true)
	List<ProductResult> selectAllProductResult(boolean status);
}

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
	
	@Query("select new com.shopwatch.api.controller.result.ProductResult(p.name, p.price_old, p.price_new, p.images, p.colorWatch, p.brand, p.create_at) from Product p where p.status = ?1")
	List<ProductResult> selectAllProductResult(boolean status);
}

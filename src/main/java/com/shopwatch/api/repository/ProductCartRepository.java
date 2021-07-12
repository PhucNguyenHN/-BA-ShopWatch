package com.shopwatch.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopwatch.api.entity.ProductCart;

@Repository
public interface ProductCartRepository extends JpaRepository<ProductCart, Integer>{

}

package com.shopwatch.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopwatch.api.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

}

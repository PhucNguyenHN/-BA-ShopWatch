package com.shopwatch.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopwatch.api.entity.Cart;
import com.shopwatch.api.entity.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	Cart findById(int id);
	
	List<Cart> findByUser(User user);
}

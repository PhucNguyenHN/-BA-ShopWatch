package com.shopwatch.api.service;

import java.util.List;

import com.shopwatch.api.dto.CartDTO;
import com.shopwatch.api.entity.Cart;

public interface CartService {
	Cart findById(int id);
	
	Cart createCart(CartDTO cartDTO);
	
	boolean changeStatusCart(int id);
	
	List<Cart> getCartByUserId(int user_id);
}

package com.shopwatch.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopwatch.api.dto.CartDTO;
import com.shopwatch.api.entity.Cart;
import com.shopwatch.api.entity.User;
import com.shopwatch.api.repository.CartRepository;
import com.shopwatch.api.repository.UserRepository;
import com.shopwatch.api.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public Cart findById(int id) {
		// TODO Auto-generated method stub
		return cartRepository.findById(id);
	}
	
	@Override
	public Cart createCart(CartDTO cartDTO) {
		Date datetimeNow = new Date();
		User user = userRepository.findById(Integer.parseInt(cartDTO.getUser_id()));
		Cart cartCheck = cartRepository.findByUserAndStatus(user, true);
		// TODO Auto-generated method stub
		if (cartCheck == null) {
			Cart cart = new Cart();
			if (user != null) {
				cart.setUser(user);
			}else{
				cart.setUser(null);
			}
			cart.setStatus(true);
			cart.setCreate_at(datetimeNow);
			cart.setUpdate_at(datetimeNow);
			
			
			return cartRepository.save(cart);
		}
		
		return cartCheck;
	}

	@Override
	public boolean changeStatusCart(int id) {
		// TODO Auto-generated method stub
		boolean result = false;
		Date datetimeNow = new Date();
		Cart cart = cartRepository.findById(id);
		if (cart.isStatus()) {
			cart.setStatus(false);
			cart.setUpdate_at(datetimeNow);
			if (cartRepository.save(cart) != null) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public List<Cart> getCartByUserId(int user_id) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(user_id);
		List<Cart> listCart = cartRepository.findByUser(user);
		
		return listCart;
	}

	@Override
	public Cart findByUseridAndStatusTrue(int id) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id);
		if (user != null) {
			Cart cart = cartRepository.findByUserAndStatus(user, true);
			return cart;
		}else {
			return null;
		}
	}
}

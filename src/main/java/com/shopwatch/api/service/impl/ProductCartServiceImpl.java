package com.shopwatch.api.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopwatch.api.dto.ProductCartDTO;
import com.shopwatch.api.dto.UpdateCartDTO;
import com.shopwatch.api.entity.Cart;
import com.shopwatch.api.entity.Product;
import com.shopwatch.api.entity.ProductCart;
import com.shopwatch.api.repository.CartRepository;
import com.shopwatch.api.repository.ProductCartRepository;
import com.shopwatch.api.repository.ProductRepository;
import com.shopwatch.api.service.ProductCartService;

@Service
public class ProductCartServiceImpl implements ProductCartService{
	
	@Autowired
	private ProductCartRepository productCartRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CartRepository cartRepository;

	@Override
	public ProductCart addProductCart(ProductCartDTO productCartDTO) {
		Date datetimeNow = new Date();
		//GET Product , Cart By ID
		Product product = productRepository.findById(productCartDTO.getProduct_id());
		Cart cart = cartRepository.findById(productCartDTO.getCart_id());
		ProductCart productCartCheck = productCartRepository.findByProductIdAndCartId(productCartDTO.getProduct_id(), productCartDTO.getCart_id());
		if (productCartCheck == null) {
			ProductCart productCart = new ProductCart();
			productCart.setProduct(product);
			productCart.setCart(cart);
			productCart.setQuantity(productCartDTO.getQuantity());
			productCart.setPrice_final(product.getPrice_new());
			productCart.setTotal_item(productCart.getQuantity() * productCart.getPrice_final());
			productCart.setCreate_at(datetimeNow);
			productCart.setUpdate_at(datetimeNow);
			return productCartRepository.save(productCart);
		}else {
			productCartCheck.setQuantity(productCartDTO.getQuantity() + productCartCheck.getQuantity());
			productCartCheck.setTotal_item(productCartCheck.getTotal_item() + (productCartCheck.getPrice_final() * productCartDTO.getQuantity()));
			productCartCheck.setUpdate_at(datetimeNow);
			return productCartRepository.save(productCartCheck);
		}
		
	}

	@Override
	public boolean deleteProductCart(int id) {
		boolean result = false;
		// TODO Auto-generated method stub
		ProductCart productCart = productCartRepository.findById(id);
		if (productCart != null) {
			productCartRepository.delete(productCart);
			result = true;
		}
		return result;
	}

	@Override
	public ProductCart updateProductCart(UpdateCartDTO updateCartDTO) {
		// TODO Auto-generated method stub
		Date datetimeNow = new Date();
		ProductCart productCart = productCartRepository.findById(updateCartDTO.getProductCart_id());
		productCart.setQuantity(updateCartDTO.getQuantity());
		productCart.setTotal_item(updateCartDTO.getQuantity() * productCart.getPrice_final());
		productCart.setUpdate_at(datetimeNow);
		return productCartRepository.save(productCart);
	}


}

package com.shopwatch.api.service;

import java.util.List;

import com.shopwatch.api.dto.ProductCartDTO;
import com.shopwatch.api.dto.UpdateCartDTO;
import com.shopwatch.api.entity.ProductCart;

public interface ProductCartService {
	ProductCart addProductCart(ProductCartDTO productCartDTO);
	
	boolean deleteProductCart(int id);
	
	//So luong quantity la cai moi nhat
	ProductCart updateProductCart(UpdateCartDTO updateCartDTO);
}

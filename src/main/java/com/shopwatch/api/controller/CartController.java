package com.shopwatch.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopwatch.api.controller.result.ResponseResult;
import com.shopwatch.api.dto.CartDTO;
import com.shopwatch.api.dto.ProductCartDTO;
import com.shopwatch.api.dto.UpdateCartDTO;
import com.shopwatch.api.entity.Cart;
import com.shopwatch.api.entity.Product;
import com.shopwatch.api.entity.ProductCart;
import com.shopwatch.api.repository.ProductCartRepository;
import com.shopwatch.api.service.ProductCartService;
import com.shopwatch.api.service.CartService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api")
public class CartController {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductCartService productCartService;
	@Autowired
	private ProductCartRepository productCartRepository;
	
	@CrossOrigin
	@GetMapping("cart/{id}")
	ResponseResult<Cart> findCartById(@PathVariable int id) {
		String mgs;
		Cart cart = cartService.findById(id);
		if (cart != null) {
			mgs = "Cart cần tìm!";
		} else {
			mgs = "Id Cart ko tồn tại!";
		}

		return new ResponseResult<Cart>(mgs, cart);
	}
	
	@CrossOrigin
	@GetMapping("cart/checkByUserId/{id}")
	ResponseResult<Cart> CheckCartByUserId(@PathVariable int id) {
		String mgs;
		Cart cart = cartService.findByUseridAndStatusTrue(id);
		if (cart != null) {
			mgs = "User này đang có Cart tồn tại!";
		} else {
			mgs = "User này ko tồn tại Giỏ hàng!";
		}

		return new ResponseResult<Cart>(mgs, cart);
	}
	
	@CrossOrigin
	@PostMapping("/cart")
	ResponseResult<Cart> createNewCart(@RequestBody CartDTO cartDTO){
		String mgs;
		Cart cart = cartService.createCart(cartDTO);
		if (cart != null) {
			mgs = "Tạo mới Cart thành công!";
			return new ResponseResult<Cart>(mgs, cart);
		}
		
		return new ResponseResult<Cart>("Tạo mới thất bại!", cart);
	}
	
	@CrossOrigin
	@PostMapping("cart/addtocart")
	ResponseResult<Cart> AddToCart(@RequestBody ProductCartDTO productCartDTO) {
		String mgs;
		Cart cart = cartService.findById(productCartDTO.getCart_id());
		if (cart != null) {
			productCartService.addProductCart(productCartDTO);
			mgs = "Add To Cart thành côg!";
		} else {
			mgs = "Add To Cart thất bại!";
		}

		return new ResponseResult<Cart>(mgs, cart);
	}
	
	@CrossOrigin
	@PutMapping("cart/updatetocart")
	ResponseResult<Cart> UpdateToCart(@RequestBody UpdateCartDTO updateCartDTO){
		String mgs;
		ProductCart productCartCheck = productCartRepository.findById(updateCartDTO.getProductCart_id());
		
		ProductCart productCart = productCartService.updateProductCart(updateCartDTO);
		if (productCart != null) {
			mgs = "Update Cart thành công!";
		}else {
			mgs = "Update Cart thất bại!";
		}
		Cart cart = cartService.findById(productCartCheck.getCart().getId());
		
		return new ResponseResult<Cart>(mgs, cart);
	}
	
	//delete Product on Cart
	@CrossOrigin
	@DeleteMapping("cart/deletetocart/{id}")
	ResponseResult<Object> deteteProductToCart(@PathVariable int id){
		boolean check = productCartService.deleteProductCart(id);
		if (check) {
			return new ResponseResult<Object>("Xóa thành công!", null);
		} else {
			return new ResponseResult<Object>("Xóa Thất Bại!", null);
		}
	}
}

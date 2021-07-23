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

import com.shopwatch.api.controller.result.ProductResult;
import com.shopwatch.api.controller.result.ResponseResult;
import com.shopwatch.api.dto.BrandDTO;
import com.shopwatch.api.dto.ProductDTO;
import com.shopwatch.api.entity.Brand;
import com.shopwatch.api.entity.Product;
import com.shopwatch.api.service.BrandService;
import com.shopwatch.api.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@CrossOrigin
	@GetMapping("/product/{id}")
	ResponseResult<Product> findProductById(@PathVariable int id){
		String mgs;
		Product product = productService.findById(id);
		if (product != null) {
			mgs = "Product cần tìm!";
		} else {
			mgs = "Id Product ko tồn tại!";
		}

		return new ResponseResult<Product>(mgs, product);
	}
	
	@CrossOrigin
	@GetMapping("/product")
	ResponseResult<List<ProductResult>> findAllProductByDB(){
//		return brandService.selectAllBrand();
		String mgs;
		List<ProductResult> listProductResult = productService.findAllProduct();
		
		if (!listProductResult.isEmpty()) {
			mgs = "Tất cả các Product.";
		} else {
			mgs = "Bảng Product rỗng.";
		}
		return new ResponseResult<List<ProductResult>>(mgs, listProductResult);
	}
	
	@CrossOrigin
	@PostMapping("/product")
	ResponseResult<Product> createProduct(@RequestBody ProductDTO productDTO) {
		String mgs;
		Product product = productService.createProduct(productDTO);
		if (product != null) {
			mgs = "Thêm mới thành công!";
		} else {
			mgs = "Thêm mới thất bại, kiểm tra Name";
		}
		return new ResponseResult<Product>(mgs, product);
	}
	
	@PutMapping("/product")
	ResponseResult<Product> updateProduct(@RequestBody ProductDTO productDTO) {
		String mgs;
		Product product = productService.updateProduct(productDTO);
		if (product != null) {
			mgs = "Cập nhật thành công!";
		} else {
			mgs = "Cập nhật thất bại, kiểm tra Name và dữ liệu Input!";
		}
		return new ResponseResult<Product>(mgs, product);
	}
	
	@DeleteMapping("/product/{id}")
	ResponseResult<Object> deleteProduct(@PathVariable int id) {
		
		if (productService.deleteProductById(id)) {
			return new ResponseResult<Object>("Xóa Thành Công!", null);
		} else {
			return new ResponseResult<Object>("Xóa Thất Bại!.Kiểm tra lại ID", null);
		}
	} 

}

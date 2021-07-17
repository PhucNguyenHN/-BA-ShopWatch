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
import com.shopwatch.api.dto.BrandDTO;
import com.shopwatch.api.entity.Brand;
import com.shopwatch.api.service.BrandService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@CrossOrigin
	@GetMapping("/brand/{id}")
	ResponseResult<Brand> findBrandById(@PathVariable int id){
		String mgs;
		Brand brand = brandService.findById(id);
		if (brand != null) {
			mgs = "Brand cần tìm!";
		} else {
			mgs = "Id Brand ko tồn tại!";
		}

		return new ResponseResult<Brand>(mgs, brand);
	}
	
	@CrossOrigin
	@GetMapping("/brand")
	ResponseResult<List<Brand>> findAllBrandByDB(){
//		return brandService.selectAllBrand();
		String mgs;
		List<Brand> listBrand = brandService.selectAllBrand();
		if (!listBrand.isEmpty()) {
			mgs = "Tất cả các Brand.";
		} else {
			mgs = "Bảng Brand rỗng.";
		}
		return new ResponseResult<List<Brand>>(mgs, listBrand);
	}
	
	@CrossOrigin
	@PostMapping("/brand")
	ResponseResult<Brand> createBrand(@RequestBody BrandDTO brandDTO) {
		String mgs;
		Brand brand = brandService.createNewBrand(brandDTO);
		if (brand != null) {
			mgs = "Thêm mới thành công!";
		} else {
			mgs = "Thêm mới thất bại, kiểm tra Name";
		}
		return new ResponseResult<Brand>(mgs, brand);
	}
	
	@PutMapping("/brand")
	ResponseResult<Brand> updateBrand(@RequestBody BrandDTO brandDTO) {
		String mgs;
		Brand brand = brandService.updateBrandnew(brandDTO);
		if (brand != null) {
			mgs = "Cập nhật thành công!";
		} else {
			mgs = "Cập nhật thất bại, kiểm tra Name và dữ liệu Input!";
		}
		return new ResponseResult<Brand>(mgs, brand);
	}
	
	@DeleteMapping("/brand/{id}")
	ResponseResult<Object> deleteBrand(@PathVariable int id) {
		
		if (brandService.deleteBrandById(id)) {
			return new ResponseResult<Object>("Xóa Thành Công!", null);
		} else {
			return new ResponseResult<Object>("Xóa Thất Bại!.Kiểm tra lại ID", null);
		}
	} 
}

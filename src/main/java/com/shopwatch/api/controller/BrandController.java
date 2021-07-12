package com.shopwatch.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopwatch.api.dto.BrandDTO;
import com.shopwatch.api.entity.Brand;
import com.shopwatch.api.service.BrandService;

@RestController
@RequestMapping("/v1/api")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@GetMapping("/brand/{id}")
	public Brand findBrandById(@PathVariable int id){
		return brandService.findById(id);
	}
	
	@GetMapping("/brand")
	public List<Brand> findAllBrandByDB(){
		return brandService.selectAllBrand();
	}
	
	@PostMapping("/brand")
	public Brand createBrand(@RequestBody BrandDTO brandDTO) {
		return brandService.createNewBrand(brandDTO);
	}
	
	@PutMapping("/brand")
	public Brand updateBrand(@RequestBody BrandDTO brandDTO) {
		return brandService.updateBrandnew(brandDTO);
	}
	
	@DeleteMapping("/brand/{id}")
	public void deleteBrand(@PathVariable int id) {
		brandService.deleteBrandById(id);
	} 
}

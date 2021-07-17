package com.shopwatch.api.service;

import java.util.List;

import com.shopwatch.api.dto.BrandDTO;
import com.shopwatch.api.entity.Brand;

public interface BrandService {
	
	Brand findById(int id);
	
	List<Brand> selectAllBrand();
	
	Brand createNewBrand(BrandDTO brandDTO);
	
	Brand updateBrandnew(BrandDTO brandDTO);
	
	boolean deleteBrandById(int id);
}

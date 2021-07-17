package com.shopwatch.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopwatch.api.dto.BrandDTO;
import com.shopwatch.api.entity.Brand;
import com.shopwatch.api.repository.BrandRepository;
import com.shopwatch.api.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{
	
	@Autowired
	private BrandRepository brandRepo;
	
	@Override
	public Brand findById(int id) {
		// TODO Auto-generated method stub
		return brandRepo.findById(id);
	}

	@Override
	public List<Brand> selectAllBrand() {
		// TODO Auto-generated method stub
		return brandRepo.customSelectBrand(true);
	}

	@Override
	public Brand createNewBrand(BrandDTO brandDTO) {
		Date datetimeNow = new Date();
		Brand brandTest = brandRepo.findByNameAndStatus(brandDTO.getName(), true);
		// TODO Auto-generated method stub
		if (brandTest == null) {
			Brand brand = new Brand();
			brand.setName(brandDTO.getName());
			brand.setImages(brandDTO.getImages());
			brand.setStatus(true);
			brand.setCreate_at(datetimeNow);
			brand.setUpdate_at(datetimeNow);
			return brandRepo.save(brand);
		}
		return null;
	}

	@Override
	public Brand updateBrandnew(BrandDTO brandDTO) {
		Date datetimeNow = new Date();
		// TODO Auto-generated method stub
		Brand brand = brandRepo.findById(brandDTO.getId());
		// check Name da ton tai
		Brand brandCheck = brandRepo.findByNameAndStatus(brandDTO.getName(), true);
		if (brandDTO.getName().equals(brand.getName()) || brandCheck == null) {
			brand.setName(brandDTO.getName());
			brand.setImages(brandDTO.getImages());
			
			brand.setUpdate_at(datetimeNow);
			
			return brandRepo.save(brand);
		}
		
		return null;
	}

	@Override
	public boolean deleteBrandById(int id) {
		Date datetimeNow = new Date();
		// TODO Auto-generated method stub
		Brand brand = brandRepo.findById(id);
		boolean result = false;
		if (brand.isStatus()) {
			brand.setStatus(false);
			brand.setUpdate_at(datetimeNow);
			if (brandRepo.save(brand) != null) {
				result = true;
			} 
		} 	
		return result;
		
	}

}

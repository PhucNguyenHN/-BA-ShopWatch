package com.shopwatch.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopwatch.api.dto.ProductDTO;
import com.shopwatch.api.entity.Brand;
import com.shopwatch.api.entity.ColorWatch;
import com.shopwatch.api.entity.GenderWatch;
import com.shopwatch.api.entity.Product;
import com.shopwatch.api.entity.TypeWatch;
import com.shopwatch.api.repository.BrandRepository;
import com.shopwatch.api.repository.ColorRepository;
import com.shopwatch.api.repository.GenderRepository;
import com.shopwatch.api.repository.ProductRepository;
import com.shopwatch.api.repository.TypeRepository;
import com.shopwatch.api.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ColorRepository colorRepository;
	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private TypeRepository typeRepository;
	@Autowired
	private GenderRepository genderRepository;

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.customSelectAllProduct(true);
	}

	@Override
	public Product createProduct(ProductDTO productDTO) {
		Date datetimeNow = new Date();
		Product productCheck = productRepository.findByNameAndStatus(productDTO.getName(), true);
		// Get Entity: Color, Brand, Type, Gender
		ColorWatch colorWatch = colorRepository.findById(productDTO.getColor_id());
		Brand brand = brandRepository.findById(productDTO.getBrand_id());
		TypeWatch typeWatch = typeRepository.findById(productDTO.getType_id());
		GenderWatch genderWatch = genderRepository.findById(productDTO.getGender_id());
		// TODO Auto-generated method stub
		if (productCheck == null) {
			Product product = new Product();
			product.setName(productDTO.getName());
			product.setDescription(productDTO.getDescription());
			product.setPrice_old(productDTO.getPrice_old());
			product.setPrice_new(productDTO.getPrice_new());
			product.setImages(productDTO.getImages());
			product.setColorWatch(colorWatch);
			product.setBrand(brand);
			product.setTypeWatch(typeWatch);
			product.setGenderWatch(genderWatch);
			product.setStatus(true);
			product.setCreate_at(datetimeNow);
			product.setUpdate_at(datetimeNow);
			return productRepository.save(product);
		}
		return null;
	}

	@Override
	public Product updateProduct(ProductDTO productDTO) {
		Date datetimeNow = new Date();
		// Get Entity: Color, Brand, Type, Gender
		ColorWatch colorWatch = colorRepository.findById(productDTO.getColor_id());
		Brand brand = brandRepository.findById(productDTO.getBrand_id());
		TypeWatch typeWatch = typeRepository.findById(productDTO.getType_id());
		GenderWatch genderWatch = genderRepository.findById(productDTO.getGender_id());
		// TODO Auto-generated method stub
		Product product = productRepository.findById(productDTO.getId());
		//check Name da ton tai
		Product productCheck = productRepository.findByNameAndStatus(productDTO.getName(), true);
		if (productDTO.getName().equals(product.getName()) || productCheck == null) {
			product.setName(productDTO.getName());
			product.setDescription(productDTO.getDescription());
			product.setPrice_old(productDTO.getPrice_old());
			product.setPrice_new(productDTO.getPrice_new());
			product.setImages(productDTO.getImages());
			product.setColorWatch(colorWatch);
			product.setBrand(brand);
			product.setTypeWatch(typeWatch);
			product.setGenderWatch(genderWatch);
			product.setUpdate_at(datetimeNow);
			
			return productRepository.save(product);
		}
		return null;
	}

	@Override
	public boolean deleteProductById(int id) {
		Date datetimeNow = new Date();
		boolean result = false;
		Product product =productRepository.findById(id);
		// TODO Auto-generated method stub
		if (product.isStatus()) {
			product.setStatus(false);
			product.setUpdate_at(datetimeNow);
			if (productRepository.save(product) != null) {
				result = true;
			}
		}
		return result;
	}

}

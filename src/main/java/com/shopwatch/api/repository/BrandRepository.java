package com.shopwatch.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopwatch.api.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{
	
	Brand findById(int id);
	
	Brand findByNameAndStatus(String name, boolean status);
	
	@Query(value = "select * from Brand b where b.status = ?1", nativeQuery = true)
	List<Brand> customSelectBrand(boolean status);
}

package com.shopwatch.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopwatch.api.entity.ColorWatch;

@Repository
public interface ColorRepository extends JpaRepository<ColorWatch, Integer>{
	
	ColorWatch findById(int id);
	
	ColorWatch findByNameAndStatus(String name, boolean status);
	
	@Query(value = "select * from colorwatch c where c.status = ?1", nativeQuery = true)
	List<ColorWatch> customSelectColor(boolean status);
}

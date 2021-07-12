package com.shopwatch.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopwatch.api.entity.GenderWatch;

@Repository
public interface GenderRepository extends JpaRepository<GenderWatch, Integer>{
	GenderWatch findById(int id);
	
	GenderWatch findByNameAndStatus(String name, boolean status);
	
	@Query(value = "select * from genderwatch g where g.status = ?1", nativeQuery = true)
	List<GenderWatch> customSelectGenderWatchs(boolean status);
}

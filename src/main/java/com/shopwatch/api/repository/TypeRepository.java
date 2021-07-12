package com.shopwatch.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopwatch.api.entity.TypeWatch;

@Repository
public interface TypeRepository extends JpaRepository<TypeWatch, Integer>{
	
	TypeWatch findById(int id);
	
	TypeWatch findByNameAndStatus(String name, boolean status);
	
	@Query(value = "select * from typewatch t where t.status = ?1", nativeQuery = true)
	List<TypeWatch> customSelectTypeWatchs(boolean status);

}

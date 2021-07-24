package com.shopwatch.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopwatch.api.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{
	Bill findById(int id);
	
	@Query(value = "select * from Bill b where b.status = ?1", nativeQuery = true)
	List<Bill> customSelectBill(boolean status);
}

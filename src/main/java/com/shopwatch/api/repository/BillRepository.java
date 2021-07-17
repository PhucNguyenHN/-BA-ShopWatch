package com.shopwatch.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopwatch.api.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{
	Bill findById(int id);
}

package com.shopwatch.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopwatch.api.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	
	Payment findById(int id);
}

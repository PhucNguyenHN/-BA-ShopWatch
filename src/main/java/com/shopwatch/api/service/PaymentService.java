package com.shopwatch.api.service;

import java.util.List;

import com.shopwatch.api.entity.Payment;

public interface PaymentService {
	
	Payment findById(int id);
	
	List<Payment> findAllPayment();
}

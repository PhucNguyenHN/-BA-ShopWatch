package com.shopwatch.api.service;

import java.util.List;

import com.shopwatch.api.entity.Payment;

public interface PaymentService {
	
	List<Payment> findAllPayment();
}

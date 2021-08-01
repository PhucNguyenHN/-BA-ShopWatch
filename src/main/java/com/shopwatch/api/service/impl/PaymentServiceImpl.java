package com.shopwatch.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopwatch.api.entity.Payment;
import com.shopwatch.api.repository.PaymentRepository;
import com.shopwatch.api.service.PaymentService;

import lombok.Data;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public List<Payment> findAllPayment() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}

	@Override
	public Payment findById(int id) {
		// TODO Auto-generated method stub
		return paymentRepository.findById(id);
	}

}

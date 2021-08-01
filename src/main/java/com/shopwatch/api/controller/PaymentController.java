package com.shopwatch.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopwatch.api.controller.result.ResponseResult;
import com.shopwatch.api.entity.Brand;
import com.shopwatch.api.entity.Payment;
import com.shopwatch.api.service.PaymentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@CrossOrigin
	@GetMapping("/payment")
	ResponseResult<List<Payment>> findAllPaymentByDB(){
		String mgs;
		List<Payment> listPayment = paymentService.findAllPayment();
		if (!listPayment.isEmpty()) {
			mgs = "Tất cả các Payment.";
		} else {
			mgs = "Bảng Payment rỗng.";
		}
		return new ResponseResult<List<Payment>>(mgs, listPayment);
	}
	
	@CrossOrigin
	@GetMapping("/payment/{id}")
	ResponseResult<Payment> findByIdPaymentByDB(@PathVariable int id){

		String mgs;
		Payment payment = paymentService.findById(id);
		if (payment != null) {
			mgs = "Payment cần tìm .";
		} else {
			mgs = "ko tìm thấy Payment.";
		}
		return new ResponseResult<Payment>(mgs, payment);
	}
}

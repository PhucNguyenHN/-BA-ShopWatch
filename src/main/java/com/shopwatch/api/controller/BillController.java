package com.shopwatch.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopwatch.api.controller.result.ResponseResult;
import com.shopwatch.api.dto.BillDTO;
import com.shopwatch.api.dto.CartDTO;
import com.shopwatch.api.entity.Bill;
import com.shopwatch.api.entity.Cart;
import com.shopwatch.api.service.BillService;
import com.shopwatch.api.service.CartService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api")
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@CrossOrigin
	@GetMapping("/bill/{id}")
	ResponseResult<Bill> findBillById(@PathVariable int id){
		String mgs;
		Bill bill = billService.findBillById(id);
		if (bill != null) {
			mgs = "Bill cần tìm!";
		} else {
			mgs = "Id Bill ko tồn tại!";
		}
		
		return new ResponseResult<Bill>(mgs, bill);
	}
	
	@CrossOrigin
	@PostMapping("/bill")
	ResponseResult<Bill> createNewBill(@RequestBody BillDTO billDTO){
		String mgs;
		Bill bill = billService.createNewBill(billDTO);
		if (bill != null) {
			mgs = "Tạo mới Bill thành công!";
		} else {
			mgs = "Tạo mới Bill thành công!";
		}
		
		return new ResponseResult<Bill>(mgs, bill);
	}
	
	@CrossOrigin
	@PutMapping("/bill/continueBill/{id}")
	ResponseResult<Bill> UpdateContinueBill(@PathVariable int id){
		String mgs;
		Bill bill = billService.changeContinueBill(id);
		if (bill != null) {
			mgs = "Chuyển trạng thái Đã Thanh Toán thành công!";
		} else {
			mgs = "Chuyển trạng thái Đã Thanh Toán thất bại!";
		}
		return new ResponseResult<Bill>(mgs, bill);
	}
	
	@CrossOrigin
	@PutMapping("/bill/doneBill/{id}")
	ResponseResult<Bill> UpdateDoneBill(@PathVariable int id){
		String mgs;
		Bill bill = billService.changeDoneBill(id);
		if (bill != null) {
			mgs = "Chuyển trạng thái Đã Hủy thành công!";
		} else {
			mgs = "Chuyển trạng thái Đã Hủy thất bại!";
		}
		return new ResponseResult<Bill>(mgs, bill);
	}
}

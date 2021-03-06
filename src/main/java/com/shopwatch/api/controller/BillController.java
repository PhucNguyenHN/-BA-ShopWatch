package com.shopwatch.api.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopwatch.api.controller.result.BillResult;
import com.shopwatch.api.controller.result.ResponseResult;
import com.shopwatch.api.dto.BillDTO;
import com.shopwatch.api.dto.BillProductDTO;
import com.shopwatch.api.dto.BillUpdateDTO;
import com.shopwatch.api.entity.Bill;
import com.shopwatch.api.service.BillService;

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
	@GetMapping("/bill")
	ResponseResult<List<BillResult>> findAllBill(){
		String mgs;
		List<BillResult> listBill = billService.selectAllBill();
		if (listBill != null) {
			mgs = "Tất cả các Bill.";
		} else {
			mgs = "Bảng Bill rỗng!";
		}
		
		return new ResponseResult<List<BillResult>>(mgs, listBill);
	}
	
	@CrossOrigin
	@PostMapping("/bill")
	ResponseResult<Bill> createNewBill(@RequestBody BillDTO billDTO) throws MessagingException{
		String mgs;
		Bill bill = billService.createNewBill(billDTO);
		if (bill != null) {
			mgs = "Tạo mới Bill thành công!";
		} else {
			mgs = "Tạo mới Bill thất bại!";
		}
		
		return new ResponseResult<Bill>(mgs, bill);
	}
	
	@CrossOrigin
	@PostMapping("/creatbill")
	ResponseResult<Bill> createBill(){
		String mgs;
		Bill bill = billService.createBill();
		if (bill != null) {
			mgs = "Tạo mới Bill thành công!";
		} else {
			mgs = "Tạo mới Bill thất bại!";
		}
		
		return new ResponseResult<Bill>(mgs, bill);
	}
	
	@CrossOrigin
	@PutMapping("/bill/continueBill/{id}")
	ResponseResult<Bill> UpdateContinueBill(@PathVariable int id) throws MessagingException{
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
	ResponseResult<Bill> UpdateDoneBill(@PathVariable int id) throws MessagingException{
		String mgs;
		Bill bill = billService.changeDoneBill(id);
		if (bill != null) {
			mgs = "Chuyển trạng thái Đã Hủy thành công!";
		} else {
			mgs = "Chuyển trạng thái Đã Hủy thất bại!";
		}
		return new ResponseResult<Bill>(mgs, bill);
	}
	
	@CrossOrigin
	@PutMapping("/bill/deliveryBill/{id}")
	ResponseResult<Bill> UpdateDeliveryBill(@PathVariable int id) throws MessagingException{
		String mgs;
		Bill bill = billService.changeDeliveryBill(id);
		if (bill != null) {
			mgs = "Chuyển trạng thái Đang Giao Hàng thành công!";
		} else {
			mgs = "Chuyển trạng thái Đang Giao Hàng thất bại!";
		}
		return new ResponseResult<Bill>(mgs, bill);
	}
	
	@CrossOrigin
	@PutMapping("/bill/packBill/{id}")
	ResponseResult<Bill> UpdatePackBill(@PathVariable int id) throws MessagingException{
		String mgs;
		Bill bill = billService.changePackBill(id);
		if (bill != null) {
			mgs = "Chuyển trạng thái ĐÓNG GÓI thành công!";
		} else {
			mgs = "Chuyển trạng thái ĐÓNG GÓI thất bại!";
		}
		return new ResponseResult<Bill>(mgs, bill);
	}
	
	@CrossOrigin
	@PostMapping("/createbillproduct")
	ResponseResult<Bill> createBillProduct(@RequestBody BillProductDTO billProductDTO) throws MessagingException{
		String mgs;
		Bill billProduct = billService.changeBillProduct(billProductDTO);
		if (billProduct != null) {
			mgs = "Thành công!";
		} else {
			mgs = "Thất bại!";
		}
		
		return new ResponseResult<Bill>(mgs, billProduct);
	}
	
	@CrossOrigin
	@PutMapping("/bill/updateProfile")
	ResponseResult<Bill> UpdateProfileBill(@RequestBody BillUpdateDTO billUpdateDTO){
		String mgs;
		Bill bill = billService.updateProfileBill(billUpdateDTO);
		if (bill != null) {
			mgs = "Update Profile Hóa đơn thành công!";
		} else {
			mgs = "Update Profile Hóa đơn thất bại!";
		}
		return new ResponseResult<Bill>(mgs, bill);
	}
	
	@CrossOrigin
	@PutMapping("/bill/updateProduct")
	ResponseResult<Bill> UpdateProductBill(@RequestBody BillProductDTO billProductDTO){
		String mgs;
		Bill bill = billService.updateProductBill(billProductDTO);
		if (bill != null) {
			mgs = "Update Product Hóa đơn thành công!";
		} else {
			mgs = "Update Product Hóa đơn thất bại!";
		}
		return new ResponseResult<Bill>(mgs, bill);
	}
	
	@CrossOrigin
	@GetMapping("/getbill/{id}")
	ResponseResult<List<Bill>> getBillByUserId(@PathVariable int id){
		String mgs;
		List<Bill> listBill = billService.getBillByUserId(id);
		if (listBill != null) {
			mgs = "Tất cả các Bill theo User ID.";
		} else {
			mgs = "Ko có Bill nào của userId này!!!";
		}
		
		return new ResponseResult<List<Bill>>(mgs, listBill);
	}
	
	@CrossOrigin
	@DeleteMapping("/bill/{id}")
	ResponseResult<Object> deleteBillByID(@PathVariable int id){
		String mgs;
		boolean delete = billService.deleteBillByID(id);
		if (delete) {
			mgs = "Xóa Bill thành Công !!!";
		} else {
			mgs = "Xóa Bill Thất bại!!!";
		}
		
		return new ResponseResult<Object>(mgs, null);
	}
	
}

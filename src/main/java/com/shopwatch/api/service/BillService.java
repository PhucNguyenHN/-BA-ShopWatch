package com.shopwatch.api.service;

import java.util.List;

import javax.mail.MessagingException;

import com.shopwatch.api.controller.result.BillResult;
import com.shopwatch.api.dto.BillDTO;
import com.shopwatch.api.dto.BillProductDTO;
import com.shopwatch.api.dto.BillUpdateDTO;
import com.shopwatch.api.entity.Bill;

public interface BillService {
	
	Bill findBillById(int id);
	
	List<Bill> getBillByUserId(int id);
	
	Bill createBill();
	
	Bill createNewBill(BillDTO billDTO) throws MessagingException;
	
	Bill changePackBill(int id) throws MessagingException;
	
	Bill changeDeliveryBill(int id) throws MessagingException;
	
	Bill changeContinueBill(int id) throws MessagingException;
	
	Bill changeDoneBill(int id) throws MessagingException;
	
	Bill updateProfileBill(BillUpdateDTO billUpdateDTO);
	
	Bill updateProductBill(BillProductDTO billProductDTO);
	
	List<BillResult> selectAllBill();
	
	Bill changeBillProduct(BillProductDTO billProductDTO) throws MessagingException;
	
	boolean deleteBillByID(int id);
}

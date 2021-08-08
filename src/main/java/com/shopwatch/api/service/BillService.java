package com.shopwatch.api.service;

import java.util.List;

import com.shopwatch.api.controller.result.BillResult;
import com.shopwatch.api.dto.BillDTO;
import com.shopwatch.api.dto.BillProductDTO;
import com.shopwatch.api.dto.BillUpdateDTO;
import com.shopwatch.api.entity.Bill;

public interface BillService {
	
	Bill findBillById(int id);
	
	Bill createBill();
	
	Bill createNewBill(BillDTO billDTO);
	
	Bill changePackBill(int id);
	
	Bill changeDeliveryBill(int id);
	
	Bill changeContinueBill(int id);
	
	Bill changeDoneBill(int id);
	
	Bill updateProfileBill(BillUpdateDTO billUpdateDTO);
	
	Bill updateProductBill(BillProductDTO billProductDTO);
	
	List<BillResult> selectAllBill();
	
	Bill changeBillProduct(BillProductDTO billProductDTO);
}

package com.shopwatch.api.service;

import java.util.List;

import com.shopwatch.api.dto.BillDTO;
import com.shopwatch.api.entity.Bill;

public interface BillService {
	
	Bill findBillById(int id);
	
	Bill createNewBill(BillDTO billDTO);
	
	Bill changeContinueBill(int id);
	
	Bill changeDoneBill(int id);
	
	List<Bill> selectAllBill();
}

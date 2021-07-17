package com.shopwatch.api.service;

import java.util.List;

import com.shopwatch.api.dto.BillDTO;
import com.shopwatch.api.entity.Bill;

public interface BillService {
	
	Bill findBillById(int id);
	
	Bill createNewBill(BillDTO billDTO);
	
	Bill changeContinueBill(int bill_id);
	
	Bill changeDoneBill(int bill_id);
	
	List<Bill> selectAllBill();
}

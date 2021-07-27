package com.shopwatch.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopwatch.api.dto.BillDTO;
import com.shopwatch.api.entity.Bill;
import com.shopwatch.api.entity.Cart;
import com.shopwatch.api.repository.BillRepository;
import com.shopwatch.api.repository.CartRepository;
import com.shopwatch.api.service.BillService;
import com.shopwatch.api.service.CartService;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CartService cartService;
	
	@Override
	public Bill findBillById(int id) {
		
		// TODO Auto-generated method stub
		return billRepository.findById(id);
	}

	@Override
	public Bill createNewBill(BillDTO billDTO) {
		Date datetimeNow = new Date();
		// TODO Auto-generated method stub
		Cart cart = cartRepository.findById(Integer.parseInt(billDTO.getCart_id()));
		Bill bill = new Bill();
		bill.setCart(cart);
		bill.setFullname(billDTO.getFullname());
		bill.setPhone(billDTO.getPhone());
		bill.setAddress(billDTO.getAddress());
		bill.setTotal_money(billDTO.getTotal_money());
		bill.setStatus_bill(0);
		bill.setUpdate_at(datetimeNow);
		bill.setCreate_at(datetimeNow);
		
		Bill billResuft = billRepository.save(bill);
		if (billResuft != null) {
			cartService.changeStatusCart(cart.getId());
			return billResuft;
		}

		return null;
	}

	@Override
	public List<Bill> selectAllBill() {
		// TODO Auto-generated method stub
		return billRepository.findAll();
	}

	@Override
	public Bill changeContinueBill(int id) {
		// TODO Auto-generated method stub
		Date datetimeNow = new Date();
		Bill bill = billRepository.findById(id);
		bill.setStatus_bill(1);
		bill.setUpdate_at(datetimeNow);
		return billRepository.save(bill);
	}

	@Override
	public Bill changeDoneBill(int id) {
		// TODO Auto-generated method stub
		Date datetimeNow = new Date();
		Bill bill = billRepository.findById(id);
		bill.setStatus_bill(2);
		bill.setUpdate_at(datetimeNow);
		return billRepository.save(bill);
	}

}

package com.shopwatch.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopwatch.api.controller.result.BillResult;
import com.shopwatch.api.dto.BillDTO;
import com.shopwatch.api.dto.BillProductDTO;
import com.shopwatch.api.dto.BillUpdateDTO;
import com.shopwatch.api.dto.CartDTO;
import com.shopwatch.api.dto.ProductCartDTO;
import com.shopwatch.api.entity.Bill;
import com.shopwatch.api.entity.Cart;
import com.shopwatch.api.entity.Payment;
import com.shopwatch.api.entity.Product;
import com.shopwatch.api.entity.ProductCart;
import com.shopwatch.api.entity.User;
import com.shopwatch.api.repository.BillRepository;
import com.shopwatch.api.repository.CartRepository;
import com.shopwatch.api.repository.PaymentRepository;
import com.shopwatch.api.repository.ProductRepository;
import com.shopwatch.api.repository.UserRepository;
import com.shopwatch.api.service.BillService;
import com.shopwatch.api.service.CartService;
import com.shopwatch.api.service.ProductCartService;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductCartService productCartService;
	@Autowired
	private CartService cartService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public Bill findBillById(int id) {
		
		// TODO Auto-generated method stub
		return billRepository.findById(id);
	}

	@Override
	public Bill createNewBill(BillDTO billDTO) {
		Date datetimeNow = new Date();
		// TODO Auto-generated method stub
		Payment payment = paymentRepository.findById(billDTO.getPayment_id());
		Cart cart = cartRepository.findById(Integer.parseInt(billDTO.getCart_id()));
		Bill bill = new Bill();
		bill.setCart(cart);
		bill.setFullname(billDTO.getFullname());
		bill.setPhone(billDTO.getPhone());
		bill.setEmail(billDTO.getEmail());
		bill.setAddress(billDTO.getAddress());
		bill.setTotal_money(billDTO.getTotal_money());
		bill.setStatus_bill(0);
		bill.setPayment(payment);
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
	public List<BillResult> selectAllBill() {
		// TODO Auto-generated method stub
		return billRepository.selectAllBillResult();
	}

	@Override
	public Bill changePackBill(int id) {
		// TODO Auto-generated method stub
		Date datetimeNow = new Date();
		Bill bill = billRepository.findById(id);
		bill.setStatus_bill(1);
		bill.setUpdate_at(datetimeNow);
		return billRepository.save(bill);
	}
	
	@Override
	public Bill changeDeliveryBill(int id) {
		// TODO Auto-generated method stub
		Date datetimeNow = new Date();
		Bill bill = billRepository.findById(id);
		bill.setStatus_bill(2);
		bill.setUpdate_at(datetimeNow);
		return billRepository.save(bill);
	}
	
	@Override
	public Bill changeContinueBill(int id) {
		// TODO Auto-generated method stub
		Date datetimeNow = new Date();
		Bill bill = billRepository.findById(id);
		bill.setStatus_bill(3);
		bill.setUpdate_at(datetimeNow);
		return billRepository.save(bill);
	}

	@Override
	public Bill changeDoneBill(int id) {
		// TODO Auto-generated method stub
		Date datetimeNow = new Date();
		Bill bill = billRepository.findById(id);
		bill.setStatus_bill(4);
		bill.setUpdate_at(datetimeNow);
		return billRepository.save(bill);
	}

	// Dang Bao tri
	@Override
	public Bill changeBillProduct(BillProductDTO billProductDTO) {
		Date datetimeNow = new Date();
		int idBill = billProductDTO.getBill_id();
		if (idBill != 0) {
			Bill billCheck = billRepository.findById(idBill);
			Cart cart = billCheck.getCart();
			
			ProductCartDTO productCartDTO = new ProductCartDTO();
			productCartDTO.setCart_id(String.valueOf(cart.getId()));
			productCartDTO.setProduct_id(billProductDTO.getProduct_id());
			productCartDTO.setQuantity(1);

			productCartService.addProductCart(productCartDTO);
			
			return billCheck;	
		}else {
			CartDTO cartDTO = new CartDTO();
			
			ProductCartDTO productCartDTO = new ProductCartDTO();
			Cart cart = cartService.createCart(cartDTO);
			productCartDTO.setCart_id(String.valueOf(cart.getId()));
			productCartDTO.setProduct_id(billProductDTO.getProduct_id());
			productCartDTO.setQuantity(1);

			productCartService.addProductCart(productCartDTO);
			
			BillDTO billDTO = new BillDTO();
			return createNewBill(billDTO);
		}
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bill updateProfileBill(BillUpdateDTO billUpdateDTO) {
		// TODO Auto-generated method stub
		Date datetimeNow = new Date();
		Bill bill = billRepository.findById(billUpdateDTO.getBill_id());
		if (bill != null) {
			bill.setFullname(billUpdateDTO.getFullname());
			bill.setEmail(billUpdateDTO.getEmail());
			bill.setPhone(billUpdateDTO.getPhone());
			bill.setAddress(billUpdateDTO.getAddress());
			bill.setUpdate_at(datetimeNow);
			
			return billRepository.save(bill);
			
		}
		return null;
	}

	@Override
	public Bill updateProductBill(BillProductDTO billProductDTO) {
		// TODO Auto-generated method stub
		Bill bill = billRepository.findById(billProductDTO.getBill_id());
		if (bill != null) {
			Cart cart = bill.getCart();
			ProductCartDTO productCartDTO = new ProductCartDTO();
			productCartDTO.setCart_id(String.valueOf(cart.getId()));
			productCartDTO.setProduct_id(billProductDTO.getProduct_id());
			productCartDTO.setQuantity(1);
			productCartService.addProductCart(productCartDTO);
			
			return billRepository.save(bill);
			
		}
		return null;
	}

	@Override
	public Bill createBill() {
		// TODO Auto-generated method stub
		Date datetimeNow = new Date();
		Payment payment = paymentRepository.findById(2);
		Bill bill = new Bill();
		Cart cart = new Cart();
		cart.setStatus(true);
		cart.setCreate_at(datetimeNow);
		cart.setUpdate_at(datetimeNow);
		Cart cartrs = cartRepository.save(cart);
		
		bill.setCart(cartrs);
		bill.setStatus_bill(0);
		bill.setPayment(payment);
		bill.setUpdate_at(datetimeNow);
		bill.setCreate_at(datetimeNow);
		
		
		return billRepository.save(bill);
	}

	@Override
	public List<BillResult> getBillByUserId(int id) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id);
		if (user != null) {
			List<BillResult> listBillResults = billRepository.selectAllBillByUser(user);
			return listBillResults;
		}
		return null;
	}



}

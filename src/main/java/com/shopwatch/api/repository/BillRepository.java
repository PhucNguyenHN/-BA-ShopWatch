package com.shopwatch.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopwatch.api.controller.result.BillResult;
import com.shopwatch.api.entity.Bill;
import com.shopwatch.api.entity.User;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{
	Bill findById(int id);
	
	@Query(value = "select * from Bill b where b.status = ?1", nativeQuery = true)
	List<Bill> customSelectBill(boolean status);
	
	@Query("select new com.shopwatch.api.controller.result.BillResult(b.id, b.fullname, b.phone, b.email, b.address, b.total_money, b.status_bill, b.create_at, b.payment.description) from Bill b order by b.status_bill ASC, b.create_at DESC")
	List<BillResult> selectAllBillResult();
	
	@Query("select new com.shopwatch.api.controller.result.BillResult(b.id, b.fullname, b.phone, b.email, b.address, b.total_money, b.status_bill, b.create_at, b.payment.description) from Bill b where b.cart.user = ?1")
	List<BillResult> selectAllBillByUser(User user);
}

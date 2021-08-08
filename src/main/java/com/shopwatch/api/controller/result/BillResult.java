package com.shopwatch.api.controller.result;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BillResult {
	private int id;
	private String fullname;
	private String phone;
	private String email;
	private String address;
	private int total_money;
	private int status_bill;
	private Date create_at;
}

package com.shopwatch.api.dto;

import lombok.Data;

@Data
public class BillDTO {
	private int id;
	private int cart_id;
	private String fullname;
	private String phone;
	private String address;
	private int total_money;
}

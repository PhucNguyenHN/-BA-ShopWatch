package com.shopwatch.api.dto;

import lombok.Data;

@Data
public class BillUpdateDTO {
	private int bill_id;
	private String fullname;
	private String phone;
	private String email;
	private String address;
}

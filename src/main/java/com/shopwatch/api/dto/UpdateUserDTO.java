package com.shopwatch.api.dto;

import lombok.Data;

@Data
public class UpdateUserDTO {
	private int id;
	private String fullname;
	private String phone;
	private String address;
}

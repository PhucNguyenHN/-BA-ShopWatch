package com.shopwatch.api.dto;

import lombok.Data;

@Data
public class UserDTO {
	private String fullname;
	private String password;
	private String phone;
	private String email;
	private String address;
}

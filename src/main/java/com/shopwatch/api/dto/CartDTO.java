package com.shopwatch.api.dto;

import lombok.Data;

@Data
public class CartDTO {
	private int id;
	private int user_id;
	private int payment_id;
}

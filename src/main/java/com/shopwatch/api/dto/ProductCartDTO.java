package com.shopwatch.api.dto;

import lombok.Data;

@Data
public class ProductCartDTO {
	private int id;
	private int product_id;
	private int cart_id;
	private int quantity;
}

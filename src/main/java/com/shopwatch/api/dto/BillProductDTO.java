package com.shopwatch.api.dto;

import lombok.Data;

@Data
public class BillProductDTO {
	private int bill_id;
	private int product_id;
	private int quantity;
}

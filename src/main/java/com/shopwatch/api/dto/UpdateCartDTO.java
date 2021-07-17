package com.shopwatch.api.dto;

import lombok.Data;

@Data
public class UpdateCartDTO {
	private int productCart_id;
	private int quantity;
}

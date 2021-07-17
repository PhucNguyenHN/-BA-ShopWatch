package com.shopwatch.api.dto;

import lombok.Data;

@Data
public class ProductDTO {
	private int id;
	private String name;
	private String description;
	private int price_old;
	private int price_new;
	private String images;
	
	private int color_id;
	private int brand_id;
	private int type_id;
	private int gender_id;
}

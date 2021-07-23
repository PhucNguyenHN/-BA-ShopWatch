package com.shopwatch.api.controller.result;

import java.util.Date;

import lombok.Data;

@Data
public class ProductResult {
	private String name;
	private int price_old;
	private int price_new;
	private String images;
	private int color_id;
	private int brand_id;
	private Date create_at;
}

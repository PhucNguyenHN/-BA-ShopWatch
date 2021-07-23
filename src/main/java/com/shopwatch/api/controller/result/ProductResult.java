package com.shopwatch.api.controller.result;

import java.util.Date;

import com.shopwatch.api.entity.Brand;
import com.shopwatch.api.entity.ColorWatch;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResult {
	private int id;
	private String name;
	private int price_old;
	private int price_new;
	private String images;
	private ColorWatch color;
	private Brand brand;
	private Date create_at;
}

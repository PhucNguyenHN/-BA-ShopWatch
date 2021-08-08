package com.shopwatch.api.dto;

import lombok.Data;

@Data
public class ChangePassDTO {
	
	private int id;
	private String pass_old;
	private String pass_new;
}

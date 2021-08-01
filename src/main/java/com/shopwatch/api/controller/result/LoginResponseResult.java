package com.shopwatch.api.controller.result;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseResult<T> {
	private String messages;
	private String token;
	private T data;
}

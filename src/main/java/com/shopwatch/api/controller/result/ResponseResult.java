package com.shopwatch.api.controller.result;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseResult<T> {
	private String messages;
	private T data;
}

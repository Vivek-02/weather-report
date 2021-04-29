package com.linkageit.weatherreport.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseResponse {

	private Object data;
	private int statusCode;
	private int recordCount;
	private String message;

}

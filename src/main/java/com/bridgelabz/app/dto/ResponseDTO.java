package com.bridgelabz.app.dto;

import com.bridgelabz.app.model.BookDetails;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class ResponseDTO {
	private String message;
	private Object data;
	
	public ResponseDTO(String message, Object data) {
		super();
		this.message=message;
		this.data=data;
	}
	
	public ResponseDTO() {
	}
}

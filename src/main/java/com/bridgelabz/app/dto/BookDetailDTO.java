	package com.bridgelabz.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookDetailDTO {
	private long id;
	private String bookName;
	private String bookAuthor;
	private String bookDetail;
	private Double bookPrice;
	private int inStock;
	private String bookImage;
	private int bookAddedToBag;
	
	public BookDetailDTO() {
		// TODO Auto-generated constructor stub
	}


	
}

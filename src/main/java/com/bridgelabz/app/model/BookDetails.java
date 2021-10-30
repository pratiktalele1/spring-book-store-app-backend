package com.bridgelabz.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.app.dto.BookDetailDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bookDetails")
public class BookDetails {
	@Id
	private long id;
	private String bookName;
	private String bookAuthor;
	private String bookDetail;
	private Double bookPrice;
	private int inStock;
	private String bookImage;
	private int bookAddedToBag;

	public BookDetails(long id, BookDetailDTO dto) {
		this.id = id;
		this.bookName = dto.getBookName();
		this.bookAuthor = dto.getBookAuthor();
		this.bookDetail = dto.getBookDetail();
		this.bookPrice = dto.getBookPrice();
		this.inStock = dto.getInStock();
		this.bookImage=dto.getBookImage();
		this.bookAddedToBag=dto.getBookAddedToBag();
	}

	public BookDetails() {
	}
}

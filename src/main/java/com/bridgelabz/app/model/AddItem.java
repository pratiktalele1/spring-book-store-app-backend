package com.bridgelabz.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cart")
public class AddItem {
	@Id
	private long id;
	private String bookName;
	private String bookAuthor;
	private String bookDetail;
	private double bookPrice;
	private int inStock;
	private String bookImage;
	private int bookAddedToBag;

	
	public AddItem() {
	}

}

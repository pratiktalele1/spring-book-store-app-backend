package com.bridgelabz.app.service;

import com.bridgelabz.app.dto.BookDetailDTO;
import com.bridgelabz.app.dto.ResponseDTO;
import com.bridgelabz.app.model.AddItem;
import com.bridgelabz.app.model.BookDetails;

public interface IBookService {

	/**
	 * getAllDetails() method is declare
	 * @return ResponseDTO
	 */
	ResponseDTO getAllDetails();

	/**
	 * insertBooks() method is declare
	 * @return ResponseDTO
	 */
	ResponseDTO insertBooks(BookDetailDTO bookDetailDTO);

	/**
	 * deleteBookById() method is declare
	 * @return ResponseDTO
	 */
	ResponseDTO deleteBookById(int id);

	/**
	 * addItemToCart() method is declare
	 * @return ResponseDTO
	 */
	ResponseDTO addItemToCart(AddItem item);

	/**
	 * getCart() method is declare
	 * @return ResponseDTO
	 */
	ResponseDTO getCart();

	/**
	 * removeItem() method is declare
	 * @return ResponseDTO
	 */
	ResponseDTO removeItem(int id);

	/**
	 * lowToHigh() method is declare
	 * @return ResponseDTO
	 */
	ResponseDTO lowToHigh();

	/**
	 * getOneBookById() method is declare
	 * @return ResponseDTO
	 */
	ResponseDTO getOneBookById(int id);

	/**
	 * highToLow() method is declare
	 * @return ResponseDTO
	 */
	ResponseDTO highToLow();

	/**
	 * newArrivalBooks() method is declare
	 * @return ResponseDTO
	 */
	ResponseDTO newArrivalBooks();


}

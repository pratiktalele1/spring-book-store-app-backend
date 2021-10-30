package com.bridgelabz.app.controller;

import org.aspectj.weaver.patterns.HasMemberTypePatternForPerThisMatching;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.app.dto.BookDetailDTO;
import com.bridgelabz.app.dto.ResponseDTO;
import com.bridgelabz.app.model.AddItem;
import com.bridgelabz.app.model.BookDetails;
import com.bridgelabz.app.service.IBookService;


@RestController @RequestMapping("/books") @CrossOrigin
public class BooksController {
	
	/**
	 * IBookService is injected to call methods
	 */
	@Autowired
	private IBookService bookService;

	/**
	 * getAllBooks method is used to get all books
	 * @return getAllDetails response
	 */
	@GetMapping @CrossOrigin
	public ResponseEntity<ResponseDTO> getAllBooks(){
		return new ResponseEntity<>(bookService.getAllDetails(),HttpStatus.OK);
	}
	
	/**
	 * insert method is used to store book details
	 * @param bookDetailDTO
	 * @return insertBooks response
	 */
	@PostMapping @CrossOrigin
	public ResponseEntity<ResponseDTO> insert(@RequestBody BookDetailDTO bookDetailDTO){
		return new ResponseEntity<>(bookService.insertBooks(bookDetailDTO),HttpStatus.OK);
	}
	
	/**
	 * deleteById method is used to delete item from database
	 * @param id
	 * @return deleteBookById response
	 */
	@DeleteMapping("/{id}") 
	public ResponseEntity<ResponseDTO> deleteById(@PathVariable int id){
		return new ResponseEntity<>(bookService.deleteBookById(id),HttpStatus.OK);
	}
	
	/**
	 * addItem method is use to store book in cart
	 * @param item
	 * @return addItemToCart response
	 */
	@PostMapping("/addItem") @CrossOrigin
	public ResponseEntity<ResponseDTO> addItem(@RequestBody AddItem item){
//		System.out.println(item.getBookAddedToBag());
//		return null;
		return new ResponseEntity<>(bookService.addItemToCart(item),HttpStatus.OK);
	}
	
	/**
	 * cart method is use to get all cart item
	 * @return getCart response
	 */
	@GetMapping("/cart") @CrossOrigin
	public ResponseEntity<ResponseDTO> cart(){
		return new ResponseEntity<>(bookService.getCart(),HttpStatus.OK);
	}
	
	/**
	 * remove method is use to delete item from cart
	 * @param id
	 * @return removeItem response
	 */
	@DeleteMapping("/cart/{id}")
	public ResponseEntity<ResponseDTO> remove(@PathVariable int id){
		return new ResponseEntity<>(bookService.removeItem(id),HttpStatus.OK);
	}
	
	/**
	 * getLowToHigh method is use to get sorted books
	 * @return lowToHigh response
	 */
	@GetMapping("lowtohigh") @CrossOrigin
	public ResponseEntity<ResponseDTO> getLowToHigh(){
		return new ResponseEntity<>(bookService.lowToHigh(),HttpStatus.OK);
	}
	
	/**
	 * getHighToLow method is use to get sorted books
	 * @return highToLow response
	 */
	@GetMapping("hightolow") @CrossOrigin
	public ResponseEntity<ResponseDTO> getHighToLow(){
		return new ResponseEntity<>(bookService.highToLow(),HttpStatus.OK);
	}
	
	/**
	 * newArrival method is use to get sorted books
	 * @return newArrivalBooks response
	 */
	@GetMapping("newarrival") @CrossOrigin
	public ResponseEntity<ResponseDTO> newArrival(){
		return new ResponseEntity<>(bookService.newArrivalBooks(),HttpStatus.OK);
	}
	
	/**
	 * getOneById method is use to get one book using id
	 * @param id
	 * @return getOneBookById response
	 */
	@GetMapping("/getonebook/{id}")
	public ResponseEntity<ResponseDTO> getOneById(@PathVariable int id){
		return new ResponseEntity<>(bookService.getOneBookById(id),HttpStatus.OK);
	}

}

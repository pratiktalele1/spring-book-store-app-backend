package com.bridgelabz.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.app.dto.BookDetailDTO;
import com.bridgelabz.app.dto.ResponseDTO;
import com.bridgelabz.app.model.AddItem;
import com.bridgelabz.app.model.BookDetails;
import com.bridgelabz.app.repository.IBookCart;
import com.bridgelabz.app.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService {
	
	/**
	 * atomicLong to get unique id for every book
	 */
	private static AtomicLong atomicLong = new AtomicLong();

	/**
	 * IBookRepository is injected to call methods
	 */
	@Autowired
	private IBookRepository bookRepository;

	/**
	 * IBookCart is injected to call methods
	 */
	@Autowired
	private IBookCart bookCart;

	/**
	 * getAllDetails method is used to get all books
	 */
	@Override
	public ResponseDTO getAllDetails() {
		List<BookDetails> bookDetails = new ArrayList<BookDetails>();
		bookDetails = bookRepository.findAll();
		ResponseDTO dto = new ResponseDTO("getAll book details", bookDetails);
		return dto;
	}

	/**
	 * insertBooks method is used to store book in database
	 */
	@Override
	public ResponseDTO insertBooks(BookDetailDTO bookDetailDTO) {
		BookDetails bookDetails = new BookDetails(atomicLong.incrementAndGet(), bookDetailDTO);
		bookRepository.save(bookDetails);
		ResponseDTO dto = new ResponseDTO("book inserted successfully", bookDetails);
		return dto;
	}

	/**
	 * deleteBookById method is used to delete book by id
	 */
	@Override
	public ResponseDTO deleteBookById(int id) {
		List<BookDetails> bookDetails = bookRepository.findAll();
		BookDetails optional = bookDetails.stream().filter(e -> e.getId() == id).findFirst().get();
		bookRepository.delete(optional);
		ResponseDTO dto = new ResponseDTO("book delete with id->" + id, optional);
		return dto;
	}

	/**
	 * addItemToCart method is used to add item in cart database
	 */
	@Override
	public ResponseDTO addItemToCart(AddItem item) {
		
		BookDetails bookDetails=new BookDetails();
		bookDetails.setBookName(item.getBookName());
		bookDetails.setBookAuthor(item.getBookAuthor());
		bookDetails.setBookDetail(item.getBookDetail());
		bookDetails.setBookPrice(item.getBookPrice());
		bookDetails.setBookImage(item.getBookImage());
		bookDetails.setBookAddedToBag(item.getBookAddedToBag());
		bookDetails.setId(item.getId());
		
		bookRepository.save(bookDetails);
		bookCart.save(item);
		ResponseDTO dto = new ResponseDTO("item added to cart", bookDetails);
		return dto;
	}

	/**
	 * getCart method is used to get call cart item
	 */
	@Override
	public ResponseDTO getCart() {
		ResponseDTO dto = new ResponseDTO("get cart", bookCart.findAll());
		return dto;
	}

	/**
	 * removeItem method is used to delete item from cart using id
	 */
	@Override
	public ResponseDTO removeItem(int id) {
		List<AddItem> list = bookCart.findAll();
		AddItem optional = list.stream().filter(e -> e.getId() == id).findFirst().get();
		bookCart.delete(optional);
		
		List<BookDetails> bookDetails=bookRepository.findAll();
		BookDetails data=bookDetails.stream().filter(e->e.getId()==id).findFirst().get();
		data.setBookAddedToBag(0);
		bookRepository.save(data);
		
		ResponseDTO dto = new ResponseDTO("book delete with id->" + id, optional);
		return dto;
	}

	/**
	 * lowToHigh method is use to get sorted books
	 */
	@Override
	public ResponseDTO lowToHigh() {
		List<BookDetails> bookDetails = bookRepository.findAll();
		System.out.println("array before sorting");

//		for (BookDetails bookDetails2 : bookDetails) {
//			System.out.println(bookDetails2.getBookPrice());
//		}
//		System.out.println("array after sorting");
		Collections.sort(bookDetails, new Comparator<BookDetails>() {

			@Override
			public int compare(BookDetails o1, BookDetails o2) {
				return o1.getBookPrice().compareTo(o2.getBookPrice());
			}

		});

//		System.out.println("array after sorting");
//		for (BookDetails bookDetails2 : bookDetails) {
//			System.out.println(bookDetails2.getBookPrice());
//		}

		ResponseDTO dto = new ResponseDTO("getAll book details low to high", bookDetails);
		return dto;
	}

	/**
	 * highToLow method is use to get sorted books
	 */
	@Override
	public ResponseDTO highToLow() {
		List<BookDetails> bookDetails = bookRepository.findAll();
//		System.out.println("array before sorting");

//		for (BookDetails bookDetails2 : bookDetails) {
//			System.out.println(bookDetails2.getBookPrice());
//		}
//		System.out.println("array after sorting");
		Collections.sort(bookDetails, new Comparator<BookDetails>() {

			@Override
			public int compare(BookDetails o1, BookDetails o2) {
				return o2.getBookPrice().compareTo(o1.getBookPrice());
			}

		});

//		System.out.println("array after sorting");
//		for (BookDetails bookDetails2 : bookDetails) {
//			System.out.println(bookDetails2.getBookPrice());
//		}

		ResponseDTO dto = new ResponseDTO("getAll book details high to low", bookDetails);
		return dto;
	}

	/**
	 * getOneBookById method is use to get one book by id
	 */
	@Override
	public ResponseDTO getOneBookById(int id) {
		List<AddItem> addItems = bookCart.findAll();
		AddItem data = addItems.stream().filter(e -> e.getId() == id).findFirst().get();
		ResponseDTO dto = new ResponseDTO("get data by id", data);
		return dto;
	}

	/**
	 * newArrivalBooks method is use to get sorted books
	 */
	@Override
	public ResponseDTO newArrivalBooks() {
		List<BookDetails> bookDetails = bookRepository.findAll();
		return null;
	}

}

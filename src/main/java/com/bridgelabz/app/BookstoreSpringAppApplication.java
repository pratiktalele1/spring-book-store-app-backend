package com.bridgelabz.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreSpringAppApplication {

	public static void main(String[] args) {
		/**
		 * app starting
		 */
		SpringApplication.run(BookstoreSpringAppApplication.class, args);
		System.out.println("welcome to Book Store");
	}

}

package com.bridgelabz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.app.model.BookDetails;

public interface IBookRepository extends JpaRepository<BookDetails, Integer> {

}

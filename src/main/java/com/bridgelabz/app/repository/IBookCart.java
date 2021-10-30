package com.bridgelabz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.app.model.AddItem;

public interface IBookCart extends JpaRepository<AddItem, Integer> {
}

package com.netsurfingzone.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.netsurfingzone.entity.Book;

@Component
public interface BookService {
	public Book saveBook(Book book);

	public Book findById(int bookId);

	public Book getBookUsingHQL(int bookId);

	public Book updateBook(Book book);
	
	public Book getBookUsingFind(int bookId);
}

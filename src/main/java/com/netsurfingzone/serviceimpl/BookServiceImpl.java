package com.netsurfingzone.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netsurfingzone.entity.Book;
import com.netsurfingzone.repository.BookRepository;
import com.netsurfingzone.service.BookService;

@Service("bookServiceImpl")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public Book saveBook(Book book) {
		book = bookRepository.save(book);
		return book;
	}

	@Transactional
	public Book findById(int bookId) {
		Optional<Book> bookResponse = bookRepository.findById(bookId);
		return bookResponse.get();
	}
	
	@Transactional
	public Book getBookUsingHQL(int bookId) {
		String hql = "FROM Book b WHERE b.bookId = :bookId";
		Query query = entityManager.createQuery(hql, Book.class);
		query.setParameter("bookId", bookId);
		query.setHint( "org.hibernate.cacheable", "true");
		List<Book> books = query.getResultList();
		return books.get(0);
	}
	
	@Transactional
	public Book updateBook(Book book) {
		entityManager.merge(book);
		return book;
	}
	
	@Transactional
	public Book getBookUsingFind(int bookId) {
		Book response = (Book) entityManager.find(Book.class, bookId);
		return response;
		
	}

}

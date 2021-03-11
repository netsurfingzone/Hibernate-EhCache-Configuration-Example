package com.netsurfingzone.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netsurfingzone.entity.Book;


@Repository
public interface BookRepository extends CrudRepository<Book,Serializable> {
	
}

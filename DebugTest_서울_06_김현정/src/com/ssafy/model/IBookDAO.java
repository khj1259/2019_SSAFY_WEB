package com.ssafy.model;

import java.util.List;

public interface IBookDAO {

	void insertBook(Book book) throws Exception;

	List<Book> search() throws Exception;

	List<Book> searchByTitle(String title) throws Exception;

	List<Book> searchByPublisher(String publisher) throws Exception;

	List<Book> searchByPrice(int price) throws Exception;

	Book search(String isbn) throws Exception;

	void delete(String isbn) throws Exception;

}
package com.olms.services;

import java.util.List;

import com.olms.models.Book;

public interface BookService {

	public void saveBook(Book book);

	public void updateBook(Book book);

	public List<Book> allEbooks();

	public List<Book> allPhysicalBooks();

	public List<Book> findAllBooks();

	public Book findById(long id);

	public Book findByTitle(String name);

	public Book findByAuthor(String author);

	public Book findByISDN(String isdn);
	
	public void deleteById(long id);
	
	public void deleteAllBooks();
	
	public void deleteAllEbooks();
	
	public void deleteAllPhysicalBooks();
	
	public boolean isAvailableBook(long id);

	public boolean isBookExist(Book book);

	public void deleteBookById(long id);

	public List<Book> findAllBooksWithFilter(String title, String author, String isdn);

}

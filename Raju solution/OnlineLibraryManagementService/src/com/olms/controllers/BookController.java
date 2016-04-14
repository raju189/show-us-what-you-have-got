package com.olms.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.olms.models.Book;
import com.olms.services.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	/*-- Getting All Books --*/
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> listBooks(@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "author", required = false) String author,
			@RequestParam(value = "isdn", required = false) String isdn) {
		List<Book> books = new ArrayList<>();
		if ((title != null && !title.isEmpty()) || (author != null && !author.isEmpty())
				|| (isdn != null && !isdn.isEmpty())) {
			books = bookService.findAllBooksWithFilter(title, author, isdn);
		} else {
			books = bookService.findAllBooks();
		}
		if (books.isEmpty()) {
			return null;
		}
		return books;
	}

	/*-- Getting All EBooks --*/
	@RequestMapping(value = "/ebooks", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> listOfEbooks() {
		List<Book> books = bookService.allEbooks();
		if (books.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	/*-- Getting All Physical Books --*/
	@RequestMapping(value = "/pbooks", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> listOfPhysicalbooks() {
		List<Book> books = bookService.allPhysicalBooks();
		if (books.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	/*-- Search Book by Title --*/
	@RequestMapping(value = "/book/title/{title}", method = RequestMethod.GET)
	public ResponseEntity<Book> findBookByTitle(@PathVariable("title") String title) {
		Book book = bookService.findByTitle(title);
		if (book == null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	/*-- Search Book by Author --*/
	@RequestMapping(value = "/book/author/{author}", method = RequestMethod.GET)
	public ResponseEntity<Book> findBookByAuthor(@PathVariable("author") String author) {
		Book book = bookService.findByAuthor(author);
		if (book == null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	/*-- Search Book by ISDN --*/
	@RequestMapping(value = "/book/isdn/{isdn}", method = RequestMethod.GET)
	public ResponseEntity<Book> findBookByISBN(@PathVariable("isdn") String isdn) {
		Book book = bookService.findByISDN(isdn);
		if (book == null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	/*-- Search Book by ISDN --*/
	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> findBookByID(@PathVariable("id") long id) {

		Book book = bookService.findById(id);
		System.out.println(id + "   " + book);
		if (book == null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	/*-- Create a Book --*/

	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody Book book, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + book.getTitle());

		if (bookService.isBookExist(book)) {
			System.out.println("A User with name " + book.getTitle() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		bookService.saveBook(book);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(book.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/* -- Upadate Book -- */
	@RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Book> updateBook(@PathVariable("id") long id, @RequestBody Book book) {
		System.out.println("Updating User " + id);

		Book currentBook = bookService.findById(id);

		if (currentBook == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}

		currentBook.setTitle(book.getTitle());
		currentBook.setAuthor(book.getAuthor());
		currentBook.setEbook(book.isEbook());
		currentBook.setCount(book.getCount());
		currentBook.setIsdn(book.getIsdn());
		System.out.println(book.getIsdn() + "   " + currentBook);
		bookService.updateBook(currentBook);
		return new ResponseEntity<Book>(currentBook, HttpStatus.OK);
	}

	/*-- Delete a Book by Id --*/
	@RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Book> deleteBook(@PathVariable("id") long id) {
		System.out.println("Fetching & Deleting User with id " + id);

		Book book = bookService.findById(id);
		if (book == null) {
			System.out.println("Unable to delete. User with id " + id + " not found");
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}

		bookService.deleteBookById(id);
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}

	/*-- Delete a all  eBooks --*/
	@RequestMapping(value = "/ebooks", method = RequestMethod.DELETE)
	public ResponseEntity<Book> deleteEBooks() {
		System.out.println("Fetching & Deleting all Ebooks");

		List<Book> ebooks = bookService.allEbooks();
		if (ebooks.isEmpty()) {
			System.out.println("No ebooks are avaliable.");
			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		}

		bookService.deleteAllEbooks();
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}

	/*-- Delete a all  eBooks --*/
	@RequestMapping(value = "/pbooks", method = RequestMethod.DELETE)
	public ResponseEntity<Book> deletePhysicalBooks() {
		System.out.println("Fetching & Deleting all Physical Books");

		List<Book> ebooks = bookService.allPhysicalBooks();
		if (ebooks.isEmpty()) {
			System.out.println("No Physical Books are avaliable.");
			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		}

		bookService.deleteAllPhysicalBooks();
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}

	/*-- Delete a all  Books --*/
	@RequestMapping(value = "/books", method = RequestMethod.DELETE)
	public ResponseEntity<Book> deleteBooks() {
		System.out.println("Fetching & Deleting all Physical Books");

		List<Book> books = bookService.findAllBooks();
		if (books.isEmpty()) {
			System.out.println("No All Books are avaliable.");
			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		}

		bookService.deleteAllBooks();
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}

	/*-- Is Book is available --*/
	@RequestMapping(value = "/isavail/book/{id}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> isBookAvailable(@PathVariable("id") long id) {
		System.out.println("Fetching & Deleting all Physical Books");

		Book book = bookService.findById(id);
		if (book == null) {
			System.out.println("Unable to delete. User with id " + id + " not found");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		Boolean val = bookService.isAvailableBook(id);
		return new ResponseEntity<Boolean>(val, HttpStatus.OK);
	}

}

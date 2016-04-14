package com.olms.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olms.models.Book;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {

	private static final AtomicLong counter = new AtomicLong();
	private static List<Book> books;

	static {
		books = getDummyBooks();
	}

	@Override
	public void saveBook(Book book) {
		book.setId(counter.incrementAndGet());
		books.add(book);
	}

	private static List<Book> getDummyBooks() {
		List<Book> books = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Book book = new Book("xxx" + i, "xxx" + i, "xxxxxx" + i, false);
			book.setId(counter.incrementAndGet());
			book.setCount(10);
			books.add(book);
		}
		for (int i = 0; i < 5; i++) {
			Book book = new Book("xxx" + i, "xxx" + i, "xxxxxx" + i, true);
			book.setId(counter.incrementAndGet());
			book.setCount(9);
			books.add(book);
		}
		return books;
	}

	@Override
	public void updateBook(Book book) {
		int index = books.indexOf(book);
		books.set(index, book);
	}

	@Override
	public List<Book> allEbooks() {
		return books.stream().filter(book -> book.isEbook()).collect(Collectors.toList());
	}

	@Override
	public List<Book> allPhysicalBooks() {
		return books.stream().filter(book -> !book.isEbook()).collect(Collectors.toList());
	}

	@Override
	public List<Book> findAllBooks() {
		return books;
	}

	@Override
	public Book findById(long id) {
		for (Book book : books) {
			System.out.println(book.getId() + "   " + id);
			if (book.getId() == id) {
				return book;
			}
		}
		return null;
	}

	@Override
	public Book findByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().equals(title)) {
				return book;
			}
		}
		return null;
	}

	@Override
	public Book findByAuthor(String author) {
		for (Book book : books) {
			if (book.getAuthor().equals(author)) {
				return book;
			}
		}
		return null;
	}

	@Override
	public Book findByISDN(String isdn) {

		for (Book book : books) {
			if (book.getIsdn().equals(isdn)) {
				return book;
			}
		}
		return null;
	}

	@Override
	public void deleteById(long id) {
		books.remove(id);
	}

	@Override
	public void deleteAllBooks() {
		books.clear();
	}

	@Override
	public void deleteAllEbooks() {
		for (Iterator<Book> iterator = books.iterator(); iterator.hasNext();) {
			Book book = iterator.next();
			if (book.isEbook()) {
				iterator.remove();
			}
		}
	}

	@Override
	public void deleteAllPhysicalBooks() {
		for (Iterator<Book> iterator = books.iterator(); iterator.hasNext();) {
			Book book = iterator.next();
			if (!book.isEbook()) {
				iterator.remove();
			}
		}
	}

	@Override
	public boolean isAvailableBook(long id) {
		Book select = null;
		for (Book book : books) {
			if (book.getId() == id) {
				select = book;
				break;
			}
		}
		return select.getCount() > 0;
	}

	@Override
	public boolean isBookExist(Book book) {
		for (Book b : books) {
			if (b.equals(book)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void deleteBookById(long id) {
		for (Iterator<Book> iterator = books.iterator(); iterator.hasNext();) {
			Book book = iterator.next();
			if (book.getId() == id) {
				iterator.remove();
			}
		}
	}

	@Override
	public List<Book> findAllBooksWithFilter(String title, String author, String isdn) {
		Set<Book> result = new HashSet<>();
		if (title != null && !title.isEmpty()) {
			result.add(findByTitle(title));
		}
		if (author != null && !author.isEmpty()) {
			result.add(findByAuthor(author));
		}
		if (isdn != null && !isdn.isEmpty()) {
			result.add(findByISDN(isdn));
		}
		return new ArrayList<>(result);
	}

}

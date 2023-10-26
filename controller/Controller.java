package edu.qsp.lms.controller;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

import edu.qsp.lms.model.Book;
import edu.qsp.lms.model.Library;

public class Controller {

	private Library library = new Library();
	
	
	public void addBook(Book book) {
		
		List<Book> books = library.getBooks();
		
		if (books==null) {
			books=new ArrayList<>();
			library.setBooks(books);
		}
		books.add(book);
	}
	
	public Book searchBook(String bookName) {
		List<Book> books = library.getBooks();
		
		Iterator<Book> iterator=books.iterator();
		
		while (iterator.hasNext()) {
			Book book = iterator.next();
			
			if (book.getBookName().equalsIgnoreCase(bookName)) {
				return book;
			}			
		}
		return null;
	}
	
	public boolean removeBook(String bookName) { // prefer to use boolean return type for deleting 
		
		Book book = searchBook(bookName);
		if (book!=null) {
			List<Book> books = library.getBooks();
			books.remove(book);
			return true;
		}
		return false;
	}
	
	public boolean updateBookPriceByBookName(Book refBook) {
		
		Book book = searchBook(refBook.getBookName());
		if (book!=null) {
			book.setBookPrice(refBook.getBookPrice());
			return true;
		}
		return false;
	}
	
	public List<Book> getAllBooks() {
		return library.getBooks();
		
	}
}

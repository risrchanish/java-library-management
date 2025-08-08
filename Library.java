package risrchanish.library.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 *  Inside Library class I want to keep details like:
    1.	List of books availability/non-avalability
    2.	List of Users record.
 */


public class Library {

	private List<Book> books;
	private List<User> users;
	
	
	// Default constructors
	public Library() {
		
		this.books = new ArrayList<>();
		this.users = new ArrayList<>();
	}
	
	// Parameterized constructor
	
	public Library(List<Book> books,List<User> users)
	{
		this.books = books;
		this.users = users;
	}
	
	// getters and setters

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
	// add Book
	
	public void addBook(Book book)
	{
		this.books.add(book);
	}
	
	// add User
	
	public void addUser(User user)
	{
		this.users.add(user);
	}
	
	// Get the availability of books inside library
	
	public List<Book> getAvailableBooks()
	{
		return this.books.stream().filter(book -> book.isAvailable())
							.collect(Collectors.toList());
	}
	
	// Get the unavailabity of the books, books which are in circulation and not available in the library 
	
	public List<Book> getUnavailableBooks()
	{
		return this.books.stream().filter(book -> !book.isAvailable())
									.collect(Collectors.toList());
	}
	
	// check for existing books
	
	public boolean bookExists(String bookId)
	{
		return books.stream().anyMatch(book -> book.getBookId().equals(bookId));
	}
	
	// check for existing user
	
	public boolean userExists(String userId) {
	    return users.stream().anyMatch(user -> user.getUserId().equals(userId));
	}
}

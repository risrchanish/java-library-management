package risrchanish.library.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import risrchanish.library.entity.Book;
import risrchanish.library.entity.Library;
import risrchanish.library.entity.User;

public class LibraryService {

	private Library library;
	

	public LibraryService(Library library) {
		
		this.library = library;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}
	
	
	// Borrow a book from Library
	
	public boolean borrowBook(String userID, String bookId)
	{
		Optional<Book> bookIssued = library.getAvailableBooks().stream().filter(books -> books.getBookId().equals(bookId))
											.findFirst();
		
		Optional<User> userAvailability = library.getUsers().stream().filter(users -> users.getUserId().equals(userID)).findFirst();
		
		/*
		 * 		 Now getting the available Books and Users into library.
		 		and the below condition is to avoid any exception
					eg: if there is not an id match then empty optional will get stored to bookIssues and if we directly call .get then throw exception.
		 */	
		if(bookIssued.isPresent() && userAvailability.isPresent())
		{
			Book book = bookIssued.get();
			User user = userAvailability.get();
		
		// Now mark the availability of the book because it will get assign to some user.			
			book.setAvailable(false);			
			user.borrowBook(book);
		
			return true;
		
		}
		// In case of book and user not available 
		
		return false;
	}
	
	
	// List of books available with User
	
	public Set<Book> borrowedBooksByUser(String userId)
	{
		
		// first extracting the user 
		
		Optional<User> availableUsers = library.getUsers().stream().filter(user -> user.getUserId().equals(userId)).findFirst();
		
		if(availableUsers.isPresent())
		{
			User user = availableUsers.get();	
			Set<String> borrowedIds = user.getBorrowedBookIds();
			
			return library.getBooks().stream().filter(book -> borrowedIds.contains(book.getBookId()))
												.collect(Collectors.toSet());
		}
		
		return Collections.emptySet();
	}
	
	
	// Returning a book to the library
	
	
	public boolean returnBook(String userId, String bookId)
	{
		Optional<Book> bookAvailable = library.getBooks().stream().filter(book -> book.getBookId().equals(bookId)).findFirst();
		
		Optional<User> availableUser =  library.getUsers().stream().filter(user -> user.getUserId().equals(userId)).findFirst();
		
		if(bookAvailable.isPresent() && availableUser.isPresent())
		{
			Book book = bookAvailable.get();
			User user = availableUser.get();
			
			
			if(user.getBorrowedBookIds().contains(bookId))
			{
				user.retunBook(bookId);
				book.setAvailable(true);
				return true;
			}
		}
		
		return false;
	}
	
}

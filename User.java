package risrchanish.library.entity;


import java.util.Set;

/*
 *  Inside User class I want to keep details like:
    1.	id of the User
    2.	name of the User
 	3.  and I want to manage borrowed books from the Library. 
 		since, a User can borrow multiple books so I want to keep this as a List.
 */


public class User {
	
	private String userId;
	private String name;
	private Set<String> borrowedBookIds;
	
	
	
	
	
	public User(String userId, String name, Set<String> borrowedBookIds) {
		
		this.userId = userId;
		this.name = name;
		this.borrowedBookIds = borrowedBookIds;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<String> getBorrowedBookIds() {
		return borrowedBookIds;
	}


	public void setBorrowedBookIds(Set<String> borrowedBookIds) {
		this.borrowedBookIds = borrowedBookIds;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", borrowedBookIds=" + borrowedBookIds + "]";
	}
	
	
	
	
	// Borrow Book (Written this method inside user is as User should responsible for it's state)
	
	public void borrowBook(Book book) {
	    if (book != null && book.getBookId() != null) {
	        borrowedBookIds.add(book.getBookId());
	    }
	}
	
	// Returning a book (Written this method inside user is as User should responsible for it's state)
	
	public boolean retunBook(String bookId)
	{
		return borrowedBookIds.remove(bookId);
	}

}

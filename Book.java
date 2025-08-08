package risrchanish.library.entity;

/*
 *  Inside Book class I want to keep details like:
    1.	id of the Book
    2.	title of the Book
  	3.  author of the Book
 	4.  and at last the availability of the Book.
 */

public class Book {

	private String bookId;
	private String title;
	private String author;
	private boolean isAvailable;
	
	
	public Book(String bookId, String title, String author, boolean isAvailable) {
		
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.isAvailable = isAvailable;
	}
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", isAvailable=" + isAvailable
				+ "]";
	}
	
	
	
	
}

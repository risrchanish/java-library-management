package risrchanish.library;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import risrchanish.library.entity.Book;
import risrchanish.library.entity.Library;
import risrchanish.library.entity.User;
import risrchanish.library.service.LibraryService;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner scanner = new Scanner(System.in);
    	
        Library lab  = new Library();
        LibraryService labService = new LibraryService(lab);
        
        boolean running = true;
        
        while(running)
        {
        	System.out.println("\n-----Library Menu--------\n");
        	System.out.println("Press 1 to add a book");
        	System.out.println("Press 2 to add a user");
        	System.out.println("Press 3 to borrow a book");
        	System.out.println("Press 4 to return a book");
        	System.out.println("Press 5 to view available books");
        	System.out.println("Press 6 to view borrowed books");
        	System.out.println("Press 7 to Exit");
        	System.out.println("Enter your choice: ");
        	
        	int userInput = scanner.nextInt();
        	
        	scanner.nextLine(); // consumes the next line
        	
        	switch(userInput)
        	{
        	
        	// Add Book
        	
        		case 1 ->{ 
        		
        			System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    
                    if(lab.bookExists(bookId))
                    {
                    	System.out.println("Book Id already exists. Please use another Unique ID");
                    	break;
                    }
                    
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    Book book = new Book(bookId, title, author, true);
                    lab.addBook(book);
                    System.out.println("Book added successfully.");
                    break;
        		}   
                    
        	// Add User
        		
        		case 2 -> { 
        			System.out.print("Enter User ID: ");
        			String userId = scanner.nextLine();
        			
        			if(lab.userExists(userId))
        			{
        				System.out.println("User exists with the ID. Please use another Unique ID");
        				break;
        			}
        			
        			System.out.print("Enter Name: ");
        			String name = scanner.nextLine();
        			User user = new User(userId, name, new HashSet<>());
        			lab.addUser(user);
        			System.out.println("User added successfully.");
        			break;
        			
        		}

        	// Borrow Book
        		
        		case 3 -> {
        			System.out.print("Enter User ID: ");
        			String borrowerId = scanner.nextLine();
        			System.out.print("Enter Book ID to borrow: ");
        			String borrowBookId = scanner.nextLine();
        			boolean borrowed = labService.borrowBook(borrowerId, borrowBookId);
        			if (borrowed) {
        				System.out.println("Book borrowed successfully.");
        			} else {
        						System.out.println("Borrowing failed. Book may be unavailable or User not found.");
        					}
        			break;
        			
        		}

        	// Return Book
        		
        		case 4 -> { 
        			System.out.print("Enter User ID: ");
        			String returnUserId = scanner.nextLine();
        			System.out.print("Enter Book ID to return: ");
        			String returnBookId = scanner.nextLine();
        			boolean returned = labService.returnBook(returnUserId, returnBookId);
        			if (returned) {
        				System.out.println("Book returned successfully.");
        			} else {
        						System.out.println("Return failed. Book/User not found or not borrowed.");
        					}
        			break;
        			
        		}

        	// View Available Books
        		
        		case 5 -> {
        			System.out.println("Available Books:");
        			for (Book availableBook : lab.getAvailableBooks()) 
        			{
        				System.out.println(availableBook);
        			}
        			break;
        			
        		}

        	// View Borrowed Books by User
        		
                case 6 -> {
                	System.out.print("Enter User ID: ");
                	String viewUserId = scanner.nextLine();
                	Set<Book> borrowedBooks = labService.borrowedBooksByUser(viewUserId);
                	if (borrowedBooks.isEmpty()) 
                	{
                		System.out.println("No books borrowed or user not found.");
                	} else {
                				System.out.println("Books borrowed by user:");
                				for (Book b : borrowedBooks) 
                				{
                					System.out.println(b);
                				}
                			}
                	break;
                	
                }
                

                case 7 -> {
                	System.out.println("Are you sure, you want to exit? (yes/no): ");
                	String confirm = scanner.nextLine();
                	
                	if(confirm.equalsIgnoreCase("Yes"))
                	{
                		running = false;
                	}
                	System.out.println("Exiting Library System. Goodbye!");
                	break;
                	
                }    

                default -> {
                	System.out.println("Invalid choice.");
                                
                }            
                    

        	}
        }
        
        scanner.close();
    }
}

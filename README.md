# Java-Library-Management
A object oriented Library Management System built in Java.

# Features
- Add books with unique Ids.
- Register users with unique Ids.
- Borrow and return books.
- View borrowed books by user.
- Prevent duplicate entries.
- Clear console interface with prompts.

# Technologies Used
- Java 17+
- Java Collections (`List`, `Set`)
- Enhanced `switch` syntax
- Modular design with Service and Entity layers

## How to Run
  1. Clone the repository:
     ```bash
       git clone https://](https://github.com/risrchanish/java-library-management.git

  2. Compile and run:
     
    javac risrchanish/library/App.java
    java risrchanish.library.App
  3. Follow the menu prompts to interact with the system.

# Design Highlights
  - Encapsulation: Entities like `Book` and `User` manage their own state.
  - Service Layer: `LayerService` separates business logic.
  - Validation: Prevents duplicate User/Book Ids

 # Future Enhancements
  - File-based or database persistence
  - GUI using JavaFX or Swing
  - REST API with Spring Boot
  - Unit testing with JUnit
  - Role based access(admin vs user)

# Contributing
 - Pull requests are welcome! For major changes, please open an issue first to discuss what you'd like to change.


     

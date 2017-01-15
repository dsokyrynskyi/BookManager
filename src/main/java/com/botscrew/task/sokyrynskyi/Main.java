package com.botscrew.task.sokyrynskyi;

import com.botscrew.task.sokyrynskyi.config.Config;
import com.botscrew.task.sokyrynskyi.entity.Author;
import com.botscrew.task.sokyrynskyi.entity.Book;
import com.botscrew.task.sokyrynskyi.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

/**
 **************************************************************************************************************
 * Create a simple java project with the console interaface for library managing. Implement such commands:
 add book
 remove {book_name}
 edit book {book_name}
    user enters new name: {book_name}
 all books : return a list of all books ordered by name
 If there are few books with the same name show user the list of these books with the ability to choose only one.
 Book should have name and author.
 For storing books use relational DB.
 ***************************************************************************************************************
 * 1. Enter the command you want to perform with capital letters
   2. Next you will asked for additional parameters
   3. Press 'exit' to finish working with application
 */

public class Main {

    static ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    static Scanner scanner = new Scanner(System.in);
    static BookService service = context.getBean(BookService.class);

    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        System.out.println("---------------------WELCOME TO LIBRARY MANAGER!---------------------");
        System.out.println("Operations:");
        System.out.println("*********************************************************************");
        System.out.println("----- SHOW BOOKS");
        System.out.println("----- GET");
        System.out.println("----- ADD");
        System.out.println("----- REMOVE");
        System.out.println("----- REMOVE BY ID");
        System.out.println("----- UPDATE");
        System.out.println("----- EXIT");
        System.out.println("*********************************************************************");

        System.out.println("Enter the operation:");
        String cmd = scanner.nextLine();
        while (!cmd.equalsIgnoreCase("EXIT")){
            switch (cmd){
                case "SHOW BOOKS":  showBooks();  break;
                case "GET":         getBook();    break;
                case "ADD":         addBook();    break;
                case "REMOVE":      removeBook(); break;
                case "UPDATE":      updateBook(); break;
                case "REMOVE BY ID":removeBookById(); break;
                default:
                    System.out.println("Wrong operation, please choose a correct command!\n");
            }

            System.out.println("Enter next operation:");
            cmd = scanner.nextLine();
        }
    }

    private static void removeBookById() {
        System.out.print("Enter a ID of book you want to remove:");
        String id = scanner.nextLine();
        Long book_id;
        try{
            book_id = Long.valueOf(id);
        }
        catch (NumberFormatException e){
            System.out.println("Id must be numeric!\n");
            return;
        }
        if(!service.removeBookById(book_id)){
            System.out.println("No books with this title was found\n");
        }
        else {
            service.removeBookById(book_id);
            System.out.println("The book with ID \'"+book_id+"\' was successfully removed!\n");
        }
    }

    private static void updateBook() {
        System.out.print("Enter a TITLE of book you want to edit:");
        String title = scanner.nextLine();
        List<Book> books = service.getBookByName(title);
        if(books.isEmpty()){
            System.out.println("No books with this title was found\n");
        }
        else if(books.size()>1){
            System.out.println("It seems like we have few books of this title, you can update your book using ID");
            books.forEach(System.out::println);
            System.out.println();
        }
        else {
            System.out.print("NEW TITLE: ");
            String newTitle = scanner.nextLine();
            Book book = books.get(0);
            book.setName(newTitle);
            service.updateBook(book);
            System.out.println("The book \'"+title+"\' was successfully updated!\n");
        }
    }

    private static void removeBook() {
        System.out.print("Enter a TITLE of book you want to remove:");
        String title = scanner.nextLine();
        if(!service.removeBook(title)){
            List<Book> books = service.getBookByName(title);
            if(books.isEmpty()){
                System.out.println("No books with this title was found\n");
                return;
            }else {
                System.out.println("It seems like we have few books of this title, you can remove your book using ID");
                books.forEach(System.out::println);
                System.out.println();
                return;
            }
        }
        service.removeBook(title);
        System.out.println("The book \'"+title+"\' was successfully removed!\n");
    }

    private static void addBook() {
        System.out.println("Fill some info about new book (press \'ENTER\' for fields you want to leave empty): ");
        System.out.print("TITLE: ");
        String title = scanner.nextLine();
        System.out.print("ISBN number: ");
        String isbn = scanner.nextLine();
        System.out.print("AUTHOR: ");
        String author = scanner.nextLine();
        if(!title.equals("")){
            Book book = new Book(title);
            book.addAuthor(new Author(author));
            book.setISBN(isbn);
            service.addBook(book);
            System.out.println("New book \'"+book.getName()+"\' was successfully added to library!\n");
        }else {
            System.out.println("It's impossible to create a book without title\n");
        }
    }

    private static void getBook() {
        System.out.println("Enter book title: ");
        String title = scanner.nextLine();
        List<Book> books = service.getBookByName(title);
        if(books.isEmpty()){
            System.out.println("We haven't book with this title\n");
            return;
        }
        books.forEach(System.out::println);
        System.out.println();
    }

    private static void showBooks() {
        System.out.println("All books in the library: ");
        service.getAllBooks().forEach(System.out::println);
        System.out.println();
    }
}

package com.botscrew.task.sokyrynskyi.dao;

import com.botscrew.task.sokyrynskyi.entity.Book;

import java.util.List;

public interface BookDao {
    void addBook(Book book);
    void updateBook(Book book);
    boolean removeBook(String bookName);
    List<Book> getBookByName(String bookName);
    List<Book> getAllBooks();
    boolean removeBookById(Long id);
}

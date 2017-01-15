package com.botscrew.task.sokyrynskyi.service;

import com.botscrew.task.sokyrynskyi.dao.BookDao;
import com.botscrew.task.sokyrynskyi.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao dao;

    @Transactional(readOnly = true)
    public List<Book> getAllBooks(){
        return dao.getAllBooks();
    }

    @Transactional(readOnly = true)
    public List<Book> getBookByName(String bookName){
        return dao.getBookByName(bookName);
    }

    @Transactional
    public boolean removeBook(String bookName){
        return dao.removeBook(bookName);
    }

    @Transactional
    public boolean removeBookById(Long id){
        return dao.removeBookById(id);
    }

    @Transactional
    public void addBook(Book book){
        dao.addBook(book);
    }

    @Transactional
    public void updateBook(Book book){
        dao.updateBook(book);
    }

}

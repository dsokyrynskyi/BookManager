package com.botscrew.task.sokyrynskyi.dao;

import com.botscrew.task.sokyrynskyi.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getBookByName(String bookName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Book where name = :bookName");
        query.setParameter("bookName", bookName);
        return query.list();
    }

    @Override
    public void updateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean removeBook(String bookName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Book where name = :bookName");
        query.setParameter("bookName", bookName);
        List<Book> books = query.list();
        if (books.isEmpty() || books.size() > 1)
            return false;
        else{
            session.remove(books.get(0));
            return true;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getAllBooks() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Book").list();
    }

    @Override
    public boolean removeBookById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, id);
        if(book!=null){
            session.delete(book);
            return true;
        }
        else return false;
    }
}

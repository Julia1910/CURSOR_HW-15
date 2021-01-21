package com.cursor.dao;

import com.cursor.dao.interfaces.BookCRUD;
import com.cursor.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDao implements BookCRUD {

    private SessionFactory sessionFactory;

    @Autowired
    public BookDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean create(Book entity) {
        Boolean status = false;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        if (session.contains(entity)) {
            status = true;
        }
        session.close();
        return status;
    }

    @Override
    public Book read(int id) {
        Session session = sessionFactory.openSession();
        Book book = session.load(Book.class, id);
        session.close();
        return book;
    }

    @Override
    public void update(Book entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public boolean delete(Book entity) {
        Boolean status = false;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        if (!session.contains(entity)) {
            status = true;
        }
        return status;
    }

    @Override
    public List<Book> getAll() {
        Session session = sessionFactory.openSession();
        return (List<Book>) session.createCriteria(Book.class).list();
    }
}

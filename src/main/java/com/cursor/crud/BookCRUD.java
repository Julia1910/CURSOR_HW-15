package com.cursor.crud;

import com.cursor.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookCRUD implements CRUD<Book> {

    private SessionFactory sessionFactory;

    @Autowired
    public BookCRUD(SessionFactory sessionFactory) {
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

    }

    @Override
    public boolean delete(Book entity) {
        return false;
    }
}

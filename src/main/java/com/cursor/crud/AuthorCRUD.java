package com.cursor.crud;

import com.cursor.entities.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorCRUD implements CRUD<Author> {

    private SessionFactory sessionFactory;

    @Autowired
    public AuthorCRUD(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean create(Author entity) {
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
    public Author read(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Author author = session.load(Author.class, id);
        transaction.commit();
        session.close();
        return author;
    }

    @Override
    public void update(Author entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public boolean delete(Author entity) {
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

}

package com.cursor.crud;

import com.cursor.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCRUD implements CRUD<User> {

    private SessionFactory sessionFactory;

    @Autowired
    public UserCRUD(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean create(User entity) {
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
    public User read(int id) {
        Session session = sessionFactory.openSession();
        User user = session.load(User.class, id);
        session.close();
        return user;
    }

    @Override
    public void update(User entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public boolean delete(User entity) {
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

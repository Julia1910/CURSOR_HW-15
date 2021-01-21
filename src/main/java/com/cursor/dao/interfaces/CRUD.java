package com.cursor.dao.interfaces;

public interface CRUD<T> {

    boolean create(T entity);

    T read(int id);

    void update(T entity);

    boolean delete(T entity);
}

package com.cursor.dao.interfaces;

import com.cursor.entities.Book;

import java.util.List;

public interface BookCRUD extends CRUD<Book> {
    List<Book> getAll();
}

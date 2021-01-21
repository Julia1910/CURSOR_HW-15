package com.cursor.dao.interfaces;

import com.cursor.entities.Author;

import java.util.List;

public interface AuthorCRUD extends CRUD<Author> {

    List<Author> getAll();

}

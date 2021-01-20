package com.cursor;

import com.cursor.crud.AuthorCRUD;
import com.cursor.entities.Author;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        AuthorCRUD authorCRUD = applicationContext.getBean(AuthorCRUD.class);
        //authorCRUD.update(author);
        Author author1 = authorCRUD.read(5);
        System.out.println(author1);
        System.out.println("Done");

       // System.out.println(authorCRUD.create(author));
        //System.out.println(authorCRUD.delete(author));
    }
}

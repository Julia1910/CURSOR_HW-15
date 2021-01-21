package com.cursor;

import com.cursor.dao.AuthorDao;
import com.cursor.dao.BookDao;
import com.cursor.dao.UserDao;
import com.cursor.dao.interfaces.AuthorCRUD;
import com.cursor.dao.interfaces.BookCRUD;
import com.cursor.dao.interfaces.UserCRUD;
import com.cursor.entities.Book;
import com.cursor.entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        AuthorCRUD authorCRUD = applicationContext.getBean(AuthorDao.class);
        BookCRUD bookCRUD = applicationContext.getBean(BookDao.class);
        UserCRUD userCRUD = applicationContext.getBean(UserDao.class);
        User user1 = userCRUD.read(1);
        System.out.println(user1);
        System.out.println(user1.getBooks());
        User user2 = userCRUD.read(2);
        System.out.println(user2);
        System.out.println(user2.getBooks());
        User user3 = userCRUD.read(3);
        System.out.println(user3);
        System.out.println(user3.getBooks());
        System.out.println("All Books: ");
        bookCRUD.getAll().stream().forEach(System.out::println);
        System.out.println("All Authors: ");
        authorCRUD.getAll().stream().forEach(System.out::println);
        User newUser = applicationContext.getBean(User.class);
        newUser.setNickname("Dmytro");
        System.out.println("Creating new user: " + userCRUD.create(newUser));
        Book book = applicationContext.getBean(Book.class);
        book.setId(6);
        book.setName("The Shack");
        book.setUser(newUser);
        System.out.println("Adding new book: " + bookCRUD.create(book));
        newUser = userCRUD.read(12);
        System.out.println(newUser);
        System.out.println(newUser.getBooks());
        System.exit(0);
    }
}

package com.cursor.entities;

import org.hibernate.annotations.Proxy;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Component
@Entity
@Table(name = "users")
@Proxy(lazy = false)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "nickname")
    private String nickname;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Book> books;

    public User() {
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                nickname.equals(user.nickname) &&
                Objects.equals(books, user.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, books);
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                //", books=" + books +
                '}';
    }
}

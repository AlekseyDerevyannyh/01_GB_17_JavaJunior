package ru.gb.task3_2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gb.author2")
public class Author2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book2> books = new ArrayList<>();

    public Author2() {
    }

    public Author2(String name) {
        this.name = name;
    }

    public void addBook(Book2 book) {
        books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book2 book) {
        books.remove(book);
        book.setAuthor(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book2> getBooks() {
        return books;
    }

    public void setBooks(List<Book2> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

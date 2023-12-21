package ru.gb.task3_2;

import javax.persistence.*;

@Entity
@Table(name = "gb.book2")
public class Book2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private Author2 author;

    public Book2() {
    }

    public Book2(String name) {
        this.name = name;
    }

//    public Book2(String name, Author2 author) {
//        this.name = name;
//        this.author = author;
//    }
//
//    public Book2(Long id, String name, Author2 author) {
//        this.id = id;
//        this.name = name;
//        this.author = author;
//    }

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

    public Author2 getAuthor() {
        return author;
    }

    public void setAuthor(Author2 author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                '}';
    }
}

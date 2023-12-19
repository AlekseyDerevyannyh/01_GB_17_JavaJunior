package ru.gb.task3;

import javax.persistence.*;

@Entity
//@Table(name = "gb.author", uniqueConstraints = {
//        @UniqueConstraint(name = "name", columnNames = {"name"})
//})
@Table(name = "gb.author")
public class Author1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @OneToOne(mappedBy = "author", cascade = CascadeType.ALL)
    private Book1 book;

    public Author1() {
    }

    public Author1(String name) {
        this.name = name;
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

    public Book1 getBook() {
        return book;
    }

    public void setBook(Book1 book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

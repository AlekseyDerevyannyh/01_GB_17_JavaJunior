package ru.gb.task3_2;

import org.hibernate.Session;

import java.util.List;

public class DbJpa {

    public static void readFromTable(Connector connector) {
        try (Session session = connector.getSession()) {
            List<Book2> books = session.createQuery("FROM Book2",
                    Book2.class).getResultList();
            books.forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void insertIntoTable(Connector connector) {
        try (Session session = connector.getSession()) {
            Author2 author = new Author2("Лесков Н.С.");
            Book2 book = new Book2("Левша");
            author.addBook(book);
            session.beginTransaction();
            session.save(author);

            author = new Author2("Достоевский Ф.М.");
            book = new Book2("Записки из Мёртвого дома");
            author.addBook(book);
            session.save(author);

            author = new Author2("Чехов А.П.");
            book = new Book2("Палата №6");
            author.addBook(book);
            session.save(author);

            author = new Author2("Пастернак Б.Л.");
            book = new Book2("Доктор Живаго");
            author.addBook(book);
            session.save(author);

            author = new Author2("Пушкин А.С.");
            book = new Book2("Руслан и Людмила");
            Book2 book2 = new Book2("Евгений Онегин");
            author.addBook(book);
            author.addBook(book2);
            session.save(author);

            author = new Author2("Некрасов Н.А.");
            book = new Book2("Кому на Руси жить хорошо");
            author.addBook(book);
            session.save(author);

            author = new Author2("Гоголь Н.В.");
            book = new Book2("Вий");
            author.addBook(book);
            session.save(author);

            author = new Author2("Иванов А.С.");
            book = new Book2("Тени исчезают в полдень");
            author.addBook(book);
            session.save(author);

            author = new Author2("Булгаков М.А.");
            book = new Book2("Собачье сердце");
            author.addBook(book);
            session.save(author);

            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}

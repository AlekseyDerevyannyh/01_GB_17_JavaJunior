package ru.gb.task3;

import org.hibernate.Session;

import java.util.List;

public class DbJpa {

    public static void readFromTable(Connector connector) {
        try (Session session = connector.getSession()) {
            List<Book1> books = session.createQuery("FROM Book1",
                    Book1.class).getResultList();
            books.forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void insertIntoTable(Connector connector) {
        try (Session session = connector.getSession()) {
            Author1 author = new Author1("Лесков Н.С.");
            Book1 book = new Book1(11L, "Левша", author);
            session.beginTransaction();

            session.save(book);
            author = new Author1("Достоевский Ф.М.");
            book = new Book1(12L, "Записки из Мёртвого дома", author);
            session.save(book);
            author = new Author1("Чехов А.П.");
            book = new Book1(13L, "Палата №6", author);
            session.save(book);
            author = new Author1("Пастернак Б.Л.");
            book = new Book1(14L, "Доктор Живаго", author);
            session.save(book);
            author = new Author1("Пушкин А.С.");
            book = new Book1(15L, "Руслан и Людмила", author);
            session.save(book);
            author = new Author1("Некрасов Н.А.");
            book = new Book1(16L, "Кому на Руси жить хорошо", author);
            session.save(book);
            author = new Author1("Гоголь Н.В.");
            book = new Book1(17L, "Вий", author);
            session.save(book);
            author = new Author1();
            author.setName("Пушкин А.С.");
            book = new Book1(18L, "Евгений Онегин", author);
            session.save(book);
            author = new Author1("Иванов А.С.");
            book = new Book1(19L, "Тени исчезают в полдень", author);
            session.save(book);
            author = new Author1("Булгаков М.А.");
            book = new Book1(20L, "Собачье сердце", author);
            session.save(book);

            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}

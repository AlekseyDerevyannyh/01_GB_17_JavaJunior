package ru.gb.task1_2;

import org.hibernate.Session;

import java.util.List;

public class DbJpa {
    public static void insertIntoTable(Connector connector) {
//        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            Book book = new Book(11L, "Левша", "Лесков Н.С.");
            session.beginTransaction();

            session.save(book);
            book = new Book(12L, "Записки из Мёртвого дома", "Достоевский Ф.М.");
            session.save(book);
            book = new Book(13L, "Палата №6", "Чехов А.П.");
            session.save(book);
            book = new Book(14L, "Доктор Живаго", "Пастернак Б.Л.");
            session.save(book);
            book = new Book(15L, "Руслан и Людмила", "Пушкин А.С.");
            session.save(book);
            book = new Book(16L, "Кому на Руси жить хорошо", "Некрасов Н.А.");
            session.save(book);
            book = new Book(17L, "Вий", "Гоголь Н.В.");
            session.save(book);
            book = new Book(18L, "Евгений Онегин", "Пушкин А.С.");
            session.save(book);
            book = new Book(19L, "Тени исчезают в полдень", "Иванов А.С.");
            session.save(book);
            book = new Book(20L, "Собачье сердце", "Булгаков М.А.");
            session.save(book);

            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void readFromTable(Connector connector) {
//        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            List<Book> books = session.createQuery("SELECT B FROM Book B WHERE author='Пушкин А.С.'",
                    Book.class).getResultList();
            books.forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}

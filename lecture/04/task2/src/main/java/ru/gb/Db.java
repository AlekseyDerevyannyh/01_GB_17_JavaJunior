package ru.gb;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Db {
    private static final String URL = "jdbc:mysql://172.16.1.122:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";


    public static void toDb() {
        Connector connector = new Connector();
        Session session = connector.getSession();

        Magic magic = new Magic("Волшебная стрела", 10, 0, 0);

        session.beginTransaction();

        session.save(magic);
        magic = new Magic("Молния", 25, 0, 0);
        session.save(magic);
        magic = new Magic("Каменная кожа", 0, 0, 6);
        session.save(magic);
        magic = new Magic("Жажда крови", 0, 6, 0);
        session.save(magic);
        magic = new Magic("Жажда крови", 0, 6, 0);
        session.save(magic);
        magic = new Magic("Проклятие", 0, -3, 0);
        session.save(magic);
        magic = new Magic("Лечение", 30, 0, 0);
        session.save(magic);

        session.getTransaction().commit();
        session.close();
    }

    public static void fromDb() {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            List<Magic> books = session.createQuery("FROM Magic ", Magic.class).getResultList();
            books.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editDb() {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            String hql = "from Magic where id = :id";
            Query<Magic> query = session.createQuery(hql, Magic.class);
            query.setParameter("id", 4);
            Magic magic = query.getSingleResult();
            System.out.println(magic);
            magic.setAttBonus(100);
            magic.setName("Ярость");
            session.beginTransaction();
            session.update(magic);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteFromDb() {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            Transaction t = session.beginTransaction();
            List<Magic> magics = session.createQuery("FROM Magic ", Magic.class).getResultList();
            magics.forEach(magic -> {
                session.delete(magic);
            });
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

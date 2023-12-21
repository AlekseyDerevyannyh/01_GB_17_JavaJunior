package ru.gb.task1_2;

import java.sql.*;

public class DbJdbc {
    private static final String URL = "jdbc:mysql://172.16.1.122:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void createTable() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.execute("DROP SCHEMA IF EXISTS `gb`");
            statement.execute("CREATE SCHEMA `gb`");
            statement.execute("CREATE TABLE `gb`.`book` (" +
                    "`id` BIGINT NOT NULL," +
                    "`name` VARCHAR(255) NULL," +
                    "`author` VARCHAR(255) NULL," +
                    "PRIMARY KEY(`id`));");
        } catch(SQLException e) {
            throw new RuntimeException();
        }
    }

    public static void insertIntoTable() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO `gb`.`book` (`id`, `name`, `author`)\n" +
                    "VALUES (1, 'Война и мир', 'Толстой Л.Н.');");
            statement.execute("INSERT INTO `gb`.`book` (`id`, `name`, `author`)\n" +
                    "VALUES (2, 'Отцы и дети', 'Тургенев И.С.');");
            statement.execute("INSERT INTO `gb`.`book` (`id`, `name`, `author`)\n" +
                    "VALUES (3, 'Герой нашего времени', 'Лермонтов М.Ю.');");
            statement.execute("INSERT INTO `gb`.`book` (`id`, `name`, `author`)\n" +
                    "VALUES (4, 'Преступление и наказание', 'Достоевский Ф.М.');");
            statement.execute("INSERT INTO `gb`.`book` (`id`, `name`, `author`)\n" +
                    "VALUES (5, 'Мастер и Маргарита', 'Булгаков М.А.');");
            statement.execute("INSERT INTO `gb`.`book` (`id`, `name`, `author`)\n" +
                    "VALUES (6, 'Горе от ума', 'Грибоедов А.С.');");
            statement.execute("INSERT INTO `gb`.`book` (`id`, `name`, `author`)\n" +
                    "VALUES (7, 'Идиот', 'Достоевский Ф.М.');");
            statement.execute("INSERT INTO `gb`.`book` (`id`, `name`, `author`)\n" +
                    "VALUES (8, 'Ревизор', 'Гоголь Н.В.');");
            statement.execute("INSERT INTO `gb`.`book` (`id`, `name`, `author`)\n" +
                    "VALUES (9, 'Анна Каренина', 'Толстой Л.Н.');");
            statement.execute("INSERT INTO `gb`.`book` (`id`, `name`, `author`)\n" +
                    "VALUES (10, 'Капитанская дочка', 'Пушкин А.С.');");
        } catch(SQLException e) {
            throw new RuntimeException();
        }
    }

    public static void readFromTable() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `gb`.`book` WHERE author = 'Толстой Л.Н.';");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("author") +
                        " \"" + resultSet.getString("name") +
                        "\". id=" + resultSet.getInt("id"));
            }
        } catch(SQLException e) {
            throw new RuntimeException();
        }
    }
}

package ru.gb;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Homework {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        DbJdbc.createTable();   // 1.1 Создать таблицу book с колонками id bigint, name varchar, author varchar
        DbJdbc.insertIntoTable();   // 1.2 Добавить в таблицу 10 книг
        DbJdbc.readFromTable();     // 1.3 Сделать запрос select from book where author = 'какое-то имя' и прочитать его с помощью ResultSet

        DbJpa.insertIntoTable();    // 2.2 Создать Session и сохранить в таблицу 10 книг
        DbJpa.readFromTable();      // 2.3 Выгрузить список книг какого-то автора
    }
}

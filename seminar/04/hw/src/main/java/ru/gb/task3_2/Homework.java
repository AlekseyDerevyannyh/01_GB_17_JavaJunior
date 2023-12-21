package ru.gb.task3_2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Homework {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        Connector connector = new Connector();
        DbJpa.insertIntoTable(connector);
        DbJpa.readFromTable(connector);
    }
}

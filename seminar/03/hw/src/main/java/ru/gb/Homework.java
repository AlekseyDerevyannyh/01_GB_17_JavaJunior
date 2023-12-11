package ru.gb;

import java.util.ArrayList;
import java.util.List;

public class Homework {
    public static void main(String[] args) {
        User user1 = new User("Ivan", 30);
        MySerialize<User> mySerializeUser = new MySerialize<>(user1);
        mySerializeUser.objToFile(user1);

        List<String> files = mySerializeUser.findSerializedObjects();
        System.out.println(files);
        List<User> users = new ArrayList<>();
        for (String file : files) {
            users.add(mySerializeUser.objFromFile(file));
        }
        if (users.isEmpty()) {
            System.out.println("Не удалось найти файл для десериализации!");
        } else {
            for (User user : users) {
                System.out.printf("Name: %s. Age: %d.\n", user.getName(), user.getAge());
            }
        }

    }
}
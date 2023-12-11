package ru.gb;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class  MySerialize <T extends Serializable> {
    private final T obj;

    public MySerialize(T obj) {
        this.obj = obj;
    }

    public void objToFile(T obj) {
        String filename = obj.getClass().getName() + "_" + UUID.randomUUID();
        Path path = Path.of(filename);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            objectOutputStream.writeObject(obj);
        } catch (IOException e) {
            System.out.println("IO Error!" + e.getMessage());
        }
    }

    public T objFromFile(String filename) {
        Path path = Path.of(filename);
        T obj = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
            obj = (T) objectInputStream.readObject();
            Files.delete(path);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("IO Error!" + e.getMessage());
        }
        return obj;
    }

    public List<String> findSerializedObjects() {
        List<String> result = new ArrayList<>();
        File path = new File(".");

        String regex = this.obj.getClass().getName() + "_.{" + UUID.randomUUID().toString().length() + "}";
        for (File file : Objects.requireNonNull(path.listFiles())) {
            if (file.getName().matches(regex)) {
                result.add(file.getName());
            }
        }
        return result;
    }
}

package ru.gb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(8181)) {
            Socket client = server.accept();
            System.out.println("Подключился новый клиент: " + client);

            OutputStream outputStream = client.getOutputStream();
            new PrintWriter(outputStream);
            try (Scanner input = new Scanner(client.getInputStream());
                PrintWriter output = new PrintWriter(client.getOutputStream())) {

                output.println("Подключение произошло успешно");

                while (true) {
                    String clientInputLine = input.nextLine();
                    System.out.println("Сообщение от клиента" + clientInputLine);

                    output.println("Сообщение [" + clientInputLine + "] получено");
                }
            }

        }
    }
}

package ru.gb.zaripov.concole_chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8089)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            Socket socket = server.accept();
            System.out.println("Клиент подключился");
            new MessageOperator("Server", socket);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}

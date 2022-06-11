package ru.gb.zaripov.concole_chat;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8089)) {
            MessageOperator clientService = new MessageOperator("Client", socket);
            clientService.start();
            while (clientService.isAlive()){}
            clientService.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}

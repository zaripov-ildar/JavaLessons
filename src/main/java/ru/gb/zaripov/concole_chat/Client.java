package ru.gb.zaripov.concole_chat;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8089)) {
            new MessageOperator("Client", socket);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}

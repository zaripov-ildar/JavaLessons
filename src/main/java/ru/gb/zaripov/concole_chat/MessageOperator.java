package ru.gb.zaripov.concole_chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MessageOperator {
    private DataInputStream in;
    private DataOutputStream out;
    private final String name;
    private final Socket socket;
    private final Thread receivingThread;
    private final Thread sendingThread;
    private volatile boolean isAlive;

    public MessageOperator(String name, Socket socket) {
        this.name = name;
        this.socket = socket;
        isAlive = true;
        initiateInAndOutStreams();
        receivingThread = getReceivingThread();
        sendingThread = getSendingThread();
        start();
        join();
        close();
    }

    private void join() {
        try {
            receivingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            sendingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        receivingThread.start();
        sendingThread.start();
    }

    private void close() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Thread getReceivingThread() {
        return new Thread(() -> {
            while (isAlive) {
                String inputMsg;
                inputMsg = getMsg();
                if (inputMsg.equals("/end")) {
                    isAlive = false;
                    break;
                }
                System.out.println(inputMsg);
            }
        });
    }

    private Thread getSendingThread() {
        return new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (isAlive) {
                String outputMsg = scanner.nextLine();
                sendMsg(outputMsg);
                if (outputMsg.equals("/end")) {
                    isAlive = false;
                    break;
                }
            }
        });
    }

    private void initiateInAndOutStreams() {
        try {
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMsg(String inputMsg) {
        try {
            out.writeUTF(name + ": " + inputMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getMsg() {
        try {
            return in.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}

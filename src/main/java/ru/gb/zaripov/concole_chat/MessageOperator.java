package ru.gb.zaripov.concole_chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Locale;
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
    }

    public boolean isAlive() {
        return isAlive;
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

    public void start() {
        receivingThread.start();
        sendingThread.start();
    }

    public void close() {
        if (in != null)
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        if (out != null)
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        if (socket != null)
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private Thread getReceivingThread() {
        Thread receiver = new Thread(() -> {
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
        receiver.setDaemon(true);
        return receiver;
    }

    private Thread getSendingThread() {
        Thread sender = new Thread(() -> {
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
        sender.setDaemon(true);
        return sender;
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
        finally {
            close();
        }
    }

    private String getMsg() {
        try {
            String msg = in.readUTF();
            if (msg.toLowerCase().contains("/end"))
                return "/end";
            return msg;
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            close();
        }
        return "Couldn't get a message";
    }
}

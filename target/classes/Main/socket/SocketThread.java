/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.socket;

/**
 *
 * @author HP-PC
 */
import main.entity.ConnectionEntity;

import java.io.IOException;
import java.net.Socket;

public class SocketThread extends Thread {
    ConnectionEntity connectionEntity;

    public SocketThread(String host, int port) throws IOException {
        try {
            connectionEntity = new ConnectionEntity(new Socket(host, port));
            System.out.println("Connected to server: " + connectionEntity.socket.getInetAddress() + ":"
                    + connectionEntity.socket.getPort());

        } catch (IOException e) {
            throw new IOException("Error connecting to server: " + e.getMessage());
        }
    }

    public void sendUserName(String username) {
        connectionEntity.writer.println(username);
    }
    public void sendMessage(String type, String recipient, String message) {
        connectionEntity.writer.println(type); // personal or group
        connectionEntity.writer.println(recipient); // username or group id
        connectionEntity.writer.println(message);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String sender = connectionEntity.reader.readLine();

                if (sender == null) {
                    System.out.println("Server closed connection");
                    this.connectionEntity.socket.close();
                    break;
                }

                String message = connectionEntity.reader.readLine();
                // Append the message to the chat window
            }
        } catch (Exception e) {
            System.out.println("Error reading message from server: " + e.getMessage());
        }
    }
}
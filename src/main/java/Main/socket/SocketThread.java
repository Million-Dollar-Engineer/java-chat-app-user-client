/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.socket;

/**
 *
 * @author HP-PC
 */
import static Main.controller.NotiController.showNoti;
import Main.shareEnv.Share;
import main.entity.ConnectionEntity;
import Main.view.chatbox;
import Main.view.chatboxGroup;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketThread extends Thread {

    static ConnectionEntity connectionEntity;

    public SocketThread(String host, int port) throws IOException {
        try {
            connectionEntity = new ConnectionEntity(new Socket(host, port));
            System.out.println("Connected to server: " + connectionEntity.socket.getInetAddress() + ":"
                    + connectionEntity.socket.getPort());

        } catch (IOException e) {
            throw new IOException("Error connecting to server: " + e.getMessage());
        }
    }

    public static void sendIdUser(String id) {
        connectionEntity.writer.println(id);
    }

    public static void sendMessage(String type, String recipient, String message) {
        connectionEntity.writer.println(type); // personal or group
        connectionEntity.writer.println(recipient); // username or group id
        connectionEntity.writer.println(message);
    }

    @Override
    public void run() {
        do {
            try {
                String header = connectionEntity.reader.readLine();
                switch (header) {
                    case "msg to user" -> {
                        String recipient = connectionEntity.reader.readLine();
                        String message = connectionEntity.reader.readLine();
                        showNoti(recipient + ": " + message);
                        chatbox.appendTextToBoxChat(recipient, message);
                        break;
                    }

                    case "msg to group" -> {
                        String groupId = connectionEntity.reader.readLine();
                        String sender = connectionEntity.reader.readLine();

                        String message = connectionEntity.reader.readLine();
                        if (!sender.equals(Share.username)) {
                            showNoti(sender + ": " + message);
                        }
                        chatboxGroup.appenfTextToGroupChat(groupId, sender, message);
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error reading message from server: " + e.getMessage());
            }
        } while (true);
    }

    public static void startSocket(String host, int port) {

        SocketThread mysocket;
        try {
            mysocket = new SocketThread(host, port);
            mysocket.start();
        } catch (IOException ex) {
            Logger.getLogger(SocketThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

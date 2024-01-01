/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
        
        
import javax.swing.Timer;

/**
 *
 * @author HP-PC
 */
public class NotiController {

    public static void main(String[] args) {
        showNoti("Hello, this is a styled notification!");

    }

    public static void showNoti(String message) {
        System.out.println("voooooooooooooooooooooooooooooooooooooooooo");
        JFrame notificationFrame = new JFrame();
        notificationFrame.setUndecorated(true);

        JPanel notificationPanel = new JPanel(new BorderLayout());
        notificationPanel.setBorder(BorderFactory.createLineBorder(new Color(50, 120, 190), 2));
        notificationPanel.setBackground(new Color(210, 230, 255));

        JLabel label = new JLabel(message);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(new Color(50, 120, 190));
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        notificationPanel.add(label, BorderLayout.CENTER);
        notificationFrame.getContentPane().add(notificationPanel);

        // Set the location of the notificationPanel to the top-right corner of the primary screen
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gd = ge.getScreenDevices();
        Rectangle bounds = gd[0].getDefaultConfiguration().getBounds();

        int x = bounds.x + bounds.width - notificationPanel.getPreferredSize().width;
        int y = bounds.y;
        notificationFrame.setLocation(x, y);

        notificationFrame.pack();
        notificationFrame.setVisible(true);

        Timer timer = new Timer(3000, (ActionEvent e) -> {
            notificationFrame.dispose();
        });

        timer.setRepeats(false);
        timer.start();
    }
}

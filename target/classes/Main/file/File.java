/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.file;

/**
 *
 * @author HP-PC
 */
import Main.shareEnv.Share;

public class File {

    private static String filePath = "idUser.txt";

    // Method to write to a file using java.io
    public static void writeToFile(String content) {
        Share.userId = content;
    }

    // Method to read from a file using java.io
    public static String readFromFile() {

        return Share.userId;
    }

    public static void main(String[] args) {
        writeToFile("");
        System.out.println("Content : " + readFromFile());

    }
}

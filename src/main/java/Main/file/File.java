/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.file;

/**
 *
 * @author HP-PC
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File {
    
    private static String filePath = "idUser.txt";
    

    // Method to write to a file using java.io
    public static void writeToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write to the file
            writer.write(content);

            System.out.println("Content written to the file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read from a file using java.io
    public static String readFromFile() {
        String idUser  = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Read from the file
            String line;
            while ((line = reader.readLine()) != null) {
                idUser = line;
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return idUser;
    }
    
    public static void main(String[] args) {
        writeToFile("");
        System.out.println("Content : " + readFromFile());
        
    }
}

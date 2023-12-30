/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.controller;
import Main.file.File;
import Main.shareEnv.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author HP-PC
 */


public class AuthController {

    public static boolean apiLogin(String username, String password) {
        try {
            Share.username = username;
            // Create a URL object with the API endpoint
            URL url = new URL(Share.apiURL +"/user/login");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            connection.setRequestMethod("POST");

            // Enable output and set the content type
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            // Create the request body
            String requestBody = String.format("{\"username\":\"%s\",\"password\":\"%s\"}", username, password);

            try ( // Write the request body to the output stream
                    DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                outputStream.writeBytes(requestBody);
                outputStream.flush();
            }

            // Get the response code
            int responseCode = connection.getResponseCode();

            StringBuilder response;
            try ( // Read the response from the API
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }

            // Parse the response as JSON
            JSONObject jsonResponse = new JSONObject(response.toString());

            // Access the properties in the response body
            String message = jsonResponse.getString("message");
            String id = jsonResponse.getString("id");

            // Print the response
            System.out.println("Response Code: " + responseCode);
            System.out.println("Message: " + message);
            System.out.println("ID: " + id);

            File.writeToFile(id);
            
            if (responseCode == 200){
                return true;
            }
            
            // Close the connection
            connection.disconnect();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean apiRegister(String fullname, String username, String pass, String email, String dob, String address, String gender ){
       
            try {
            // Create a URL object with the API endpoint
            URL url = new URL(Share.apiURL +"/user/signup");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            connection.setRequestMethod("POST");

            // Enable output and set the content type
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            // Create the request body

            String requestBody = String.format("{\"username\":\"%s\",\"password\":\"%s\",\"fullname\":\"%s\",\"address\":\"%s\",\"dateOfBirth\":\"%s\",\"email\":\"%s\",\"sex\":\"%s\"}", username, pass, fullname, address, dob, email, gender);

            try ( // Write the request body to the output stream
                    DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                outputStream.writeBytes(requestBody);
                outputStream.flush();
            }

            // Get the response code
            int responseCode = connection.getResponseCode();

            StringBuilder response;
            try ( // Read the response from the API
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }

            // Parse the response as JSON
            JSONObject jsonResponse = new JSONObject(response.toString());

            // Access the properties in the response body
            String message = jsonResponse.getString("message");

            //Print the response
            System.out.println("Response Code: " + responseCode);
            System.out.println("Message: " + message);
            if (responseCode == 200){
                return true;
            }

            // Close the connection
            connection.disconnect();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
    
//    public static void main(String[] args){
//        boolean x = apiRegister( "Pham Hong Gia Bao", "baopham", "123", "phgbao@gmail.com", "2003-8-3", "TP HCM", "male");
//        if (x){
//            System.out.println("Scueesss");
//        }
//        else{
//            System.out.println("falseeeeeeeeeeeee");
//        }
//    }
}
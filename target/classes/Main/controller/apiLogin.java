/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.controller;

/**
 *
 * @author HP-PC
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;

import org.json.JSONObject;

public class apiLogin {
    public static void main(String[] args) {
        try {
            // Create a URL object with the API endpoint
            URL url = new URL("http://13.215.176.178:8881/user/login");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            connection.setRequestMethod("POST");

            // Enable output and set the content type
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            // Create the request body
            String username = "ptan21";
            String password = "1234";
            String requestBody = "{\"username\":\"ptan21\",\"password\":\"12323456\"}";

            
//            String requestBody = String.format("{\"username\":\"%s\",\"password\":\"%s\"}", username, password);

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
            
            

            //Print the response
            System.out.println("Response Code: " + responseCode);
            System.out.println("Message: " + message);
            System.out.println("ID: " + id);

            // Close the connection
            connection.disconnect();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
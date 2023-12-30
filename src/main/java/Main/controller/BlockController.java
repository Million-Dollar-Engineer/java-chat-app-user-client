/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.controller;

import Main.file.File;
import Main.shareEnv.Share;
import java.io.BufferedReader;
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
public class BlockController {
    public static boolean blockedFriend(String username){
        try {
            // Specify the URL
            String idUser = File.readFromFile();
            String apiUrl = Share.apiURL +  "/user/block-user?user_id=" + idUser + "&block_user_name=" + username;
            System.out.println(apiUrl);
            // Create a URL object
            URL url = new URL(apiUrl);

            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response code : " + responseCode);

            if (responseCode == 200) {
                return true;
            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
                return false;
            }
        } catch (IOException | JSONException e) {
            return false;
        }
    }
    
    public static String isBlocked(String username){
        String message = "";
        try {
            // Specify the URL
            String idUser = File.readFromFile();
            String apiUrl = Share.apiURL +  "/user/is-blocked?user_id=" + idUser + "&block_user_name=" + username;
            System.out.println(apiUrl);
            // Create a URL object
            URL url = new URL(apiUrl);

            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            
            
            System.out.println("Response code : " + responseCode);
                
            // Get the response message            
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
            message = jsonResponse.getString("message");
            
            if (responseCode == 200) {
                return message;
            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
                return "";
            }
        } catch (IOException | JSONException e) {
            return "";
        }
    } 
    
    
    public static boolean spamUser(String username){
        try {
            // Specify the URL
            String idUser = File.readFromFile();
            String apiUrl = Share.apiURL +  "/user/report-spam?user_id=" + idUser + "&spam_user_name=" + username + "&reason=ok";
            System.out.println(apiUrl);
            // Create a URL object
            URL url = new URL(apiUrl);

            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response code : " + responseCode);
           

            if (responseCode == 200) {
                return true;
            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
            connection.disconnect();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}

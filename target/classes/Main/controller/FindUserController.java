/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.controller;

import Main.shareEnv.Share;
import Main.view.findUser;
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
public class FindUserController {
    public static void apiFindUser(String user){
        try {
            // Create a URL object with the API endpoint
            URL url = new URL(Share.apiURL +"/user/list?username=" + user);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            connection.setRequestMethod("GET");

            // Enable output and set the content type
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            
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
            String username = jsonResponse.getString("userName");      
            String name = jsonResponse.getString("name");


            //Print the response
            System.out.println("Response Code: " + responseCode);
            System.out.println("Message: " + username);     
            System.out.println("Message: " + name);

            if (responseCode == 200){
                findUser.appendUserToLabel(name);
            }

            // Close the connection
            connection.disconnect();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
    
    public static void apiAddFriend(String user){
        try {
            // Create a URL object with the API endpoint
            URL url = new URL(Share.apiURL +"/user/add-friend?user_id=684530c0-c5c7-474d-ad32-2d407c3cd282&friend_user_name=" + user);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            connection.setRequestMethod("GET");

            // Enable output and set the content type
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            
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


            //Print the response
            System.out.println("Response Code: " + responseCode);

            if (responseCode == 200){
                findUser.addFriendNoti("Add friend successfully");
            } else {
                findUser.addFriendNoti("Add friend failed");
            }

            // Close the connection
            connection.disconnect();
        } catch (IOException | JSONException e) {
            findUser.addFriendNoti("Add friend failed");
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        apiFindUser("ptan21");
    }
}

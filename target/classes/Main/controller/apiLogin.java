/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.controller;

/**
 *
 * @author HP-PC
 */
import Main.entity.MessageEntity;
import Main.file.File;
import Main.shareEnv.Share;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

import org.json.JSONObject;

public class apiLogin {
    public static void main(String[] args){
        ArrayList<MessageEntity> history = getHistoryMessage("");
        for (MessageEntity i : history){
            System.out.println("tesst");
        }
    }
    
    public static ArrayList<MessageEntity> getHistoryMessage(String receiverUsername){
        ArrayList<MessageEntity> historyMessage = new ArrayList<>(); 
        try {
            // Specify the URL
            String idUser = File.readFromFile();
            String apiUrl = Share.apiURL +  "/message/personal-history?senderId=eed9a04a-2b72-4706-88ee-3269a8842fe6&receiverUsername=Bao22";
            // Create a URL object
            URL url = new URL(apiUrl);

            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response code : " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();

                // Parse JSON response using org.json
                JSONArray jsonArray = new JSONArray(response.toString());

                System.out.println("Friend List ");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String senderId = jsonObject.getString("senderId");
                    String senderName = jsonObject.getString("senderName");
                    String receiverId = jsonObject.getString("receiverId");
                    String receiverName = jsonObject.getString("receiverName");
                    String message = jsonObject.getString("message");
                    String createdAt = jsonObject.getString("createdAt");
                    
                    MessageEntity tmp = new MessageEntity(senderId, senderName, receiverId, receiverName, message, createdAt);
                    historyMessage.add(tmp);
                    
                    System.out.println(senderId);                    
                    System.out.println(senderName);
                    System.out.println(receiverId);
                    System.out.println(receiverName);
                    System.out.println(message);
                    System.out.println(createdAt);

                }
            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
            // Close the connection
            connection.disconnect();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return historyMessage;
    }
}
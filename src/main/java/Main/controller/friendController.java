/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import Main.shareEnv.Share;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import Main.entity.Friend;
import java.util.ArrayList;
import Main.file.File;
/**
 *
 * @author HP-PC
 */
public class FriendController {
    public static void main(String[] args) {
        ArrayList<Friend> friends = FriendController.apiFriendRequestList();
    }
    
    public static ArrayList<Friend> apiFriendList(){
        ArrayList<Friend> friendList = new ArrayList<>(); 
        try {
            // Specify the URL
            String idUser = File.readFromFile();
            String apiUrl = Share.apiURL +  "/user/friend-list?id=" + idUser;
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
                    String name = jsonObject.getString("name");
                    String userName = jsonObject.getString("userName");

                    Friend tmp = new Friend(userName, name);
                    friendList.add(tmp);
                  
                    // Now you have the values for each object
                    System.out.println("Name: " + name);
                    System.out.println("UserName: " + userName);
                    System.out.println("-----");
                }
            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
            // Close the connection
            connection.disconnect();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return friendList;
    }
    
    
    public static ArrayList<Friend> apiFriendListOnline(){
        ArrayList<Friend> onlineFriendList = new ArrayList<>();
        try {
            // Specify the URL
            String idUser = File.readFromFile();
            String apiUrl = Share.apiURL +  "/user/online-friend-list?id=" + idUser;
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

                //System.out.println("Friend List: " + jsonArray.toString());

                // Now you have your JSONArray
                // Convert JSONArray to a Java array of strings
                System.out.println("Online Friend List ");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = jsonObject.getString("name");
                    String userName = jsonObject.getString("userName");

                    Friend tmp = new Friend(userName, name);
                    onlineFriendList.add(tmp);
                }
            } else {
                    System.out.println("GET request failed. Response Code: " + responseCode);
            }

            // Close the connection
            connection.disconnect();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return onlineFriendList;
    }
    
    
    
    public static ArrayList<Friend> apiFriendRequestList(){
        ArrayList<Friend> friendList = new ArrayList<>(); 
        try {
            // Specify the URL
            String idUser = File.readFromFile();
            String apiUrl = Share.apiURL +  "/user/friend-request-list?id=" + idUser;
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

                System.out.println("Friend Request ");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = jsonObject.getString("name");
                    String userName = jsonObject.getString("userName");

                    Friend tmp = new Friend(userName, name);
                    friendList.add(tmp);
                  
                    // Now you have the values for each object
                    System.out.println("Name: " + name);
                    System.out.println("UserName: " + userName);
                    System.out.println("-----");
                }
            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
            // Close the connection
            connection.disconnect();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return friendList;
    }
    
    
    public static boolean apiAcceptFriendRequest(String username){
        try {
            // Specify the URL
            String idUser = File.readFromFile();
            String apiUrl = Share.apiURL +  "/user/accept-friend?user_id=" + idUser + "&friend_user_name=" + username;
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
                System.out.println("Accept Friend Successfully");
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
    
    public static boolean apiUnfriend(String username){
        try {
            // Specify the URL
            String idUser = File.readFromFile();
            String apiUrl = Share.apiURL +  "/user/unfriend?user_id=" + idUser + "&friend_user_name=" + username;
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
                System.out.println("Accept Friend Successfully");
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

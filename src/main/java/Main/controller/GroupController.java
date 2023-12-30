/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.controller;

import Main.entity.Friend;
import Main.entity.Group;
import Main.entity.GroupMember;
import Main.file.File;
import Main.shareEnv.Share;
import Main.view.addFriendScreen;
import Main.view.addMemberNewGroup;
import Main.view.addMemberScreen;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author HP-PC
 */
public class GroupController {
    public static ArrayList<Group> apiGroupList() {
        ArrayList<Group> groupList = new ArrayList<>();
        try {
            // Specify the URL
            String idUser = File.readFromFile();
            String apiUrl = Share.apiURL + "/user/list-my-group?user_id=" + idUser;
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
                    String id = jsonObject.getString("id");
                    String name = jsonObject.getString("name");

                    Group tmp = new Group(id, name);
                    groupList.add(tmp);

                    // Now you have the values for each object
                    System.out.println("Id: " + id);
                    System.out.println(": " + name);
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
        return groupList;
    }

    public static ArrayList<GroupMember> apiGroupMemberList(String idGroup) {
        ArrayList<GroupMember> groupList = new ArrayList<>();
        try {
            // Specify the URL
            String idUser = File.readFromFile();
            String apiUrl = Share.apiURL + "/user/list-group-member?group_id=" + idGroup;
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

                System.out.println("Group Member List ");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = jsonObject.getString("name");
                    String username = jsonObject.getString("userName");
                    String role = jsonObject.getString("role");

                    GroupMember tmp = new GroupMember(name, username, role);
                    groupList.add(tmp);

                    // Now you have the values for each object
                    System.out.println(name + " " + username + " " + role);
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
        return groupList;
    }

    public static boolean apiAddMemberToGroup(String username, String groupId) {
        try {
            // Specify the URL
            String idUser = File.readFromFile();
            String apiUrl = Share.apiURL + "/user/add-user-to-group?user_id=" + idUser + "&group_id=" + groupId + "&user_name=" + username;
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

    public static boolean apiRemoveGroupMember(String username, String groupId) {
        try {
            // Specify the URL
            String idUser = File.readFromFile();
            String apiUrl = Share.apiURL + "/user/remove-user-from-group?user_id=" + idUser + "&group_id=" + groupId + "&user_name=" + username;
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

    public static boolean apiRenameGroup(String groupName, String groupId) {
        try {
            // Specify the URL
            String idUser = File.readFromFile();
            String apiUrl = Share.apiURL + "/user/rename-group?user_id=" + idUser + "&group_id=" + groupId + "&group_name=" + groupName;
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

    public static boolean apiInviteAdmin(String groupId, String username) {
        try {
            // Specify the URL
            String idUser = File.readFromFile();
            String apiUrl = Share.apiURL + "/user/give-admin-role?user_id=" + idUser + "&group_id=" + groupId + "&user_name=" + username;
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

    public static void apiFindUser(String user) {
        try {
            // Create a URL object with the API endpoint
            URL url = new URL(Share.apiURL + "/user/list?username=" + user);

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

            if (responseCode == 200) {
                addMemberScreen.appendUserToLabel(name);
            }

            // Close the connection
            connection.disconnect();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
    
    public static void apiAddMemberNewGroup(String user) {
        try {
            // Create a URL object with the API endpoint
            URL url = new URL(Share.apiURL + "/user/list?username=" + user);

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

            if (responseCode == 200) {
                addMemberNewGroup.appendUserToLabel(name);
            }

            // Close the connection
            connection.disconnect();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
    
    public static String apiCreateNewGroup(String groupname) {
        String message = "";
        try {
            // Create a URL object with the API endpoint
            URL url = new URL(Share.apiURL + "/user/create-group?user_id=" + File.readFromFile() + "&group_name="  + groupname);

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

            // Access the properties in the response body\
            message = jsonResponse.getString("message");

            //Print the response
            System.out.println("Response Code: " + responseCode);
            System.out.println("Message: " + message);

            if (responseCode == 200) {
                return message;
            }

            // Close the connection
            connection.disconnect();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return message;
    }
    
    
}

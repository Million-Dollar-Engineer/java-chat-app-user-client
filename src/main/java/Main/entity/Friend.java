/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.entity;

/**
 *
 * @author HP-PC
 */
public class Friend {

    public String username;
    public String fullname;

    public Friend(String a, String b) {
        username = a;
        fullname = b;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }
}

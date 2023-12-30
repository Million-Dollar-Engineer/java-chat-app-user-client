/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.entity;

/**
 *
 * @author HP-PC
 */
public class GroupMember {
    public String fullname;
    public String username;
    public String role;
    
    public GroupMember(String a, String b, String c){
        fullname = a;
        username = b;
        role = c;
    }
    
    public String getRole(){
        return role;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getFullname(){
        return fullname;
    }
}

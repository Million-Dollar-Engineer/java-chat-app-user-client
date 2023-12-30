/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.entity;

/**
 *
 * @author HP-PC
 */
public class Group {
    public String idGroup;
    public String nameGroup;
    
    
    public Group(String a, String b){
        idGroup = a;
        nameGroup = b;
    }
    
      
    public String getUsername(){
        return idGroup;
    }
    
    public String getFullname(){
        return nameGroup;
    }
}

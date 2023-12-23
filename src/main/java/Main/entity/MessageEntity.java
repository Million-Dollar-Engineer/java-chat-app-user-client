/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.entity;

/**
 *
 * @author HP-PC
 */
public class MessageEntity {
    public String senderId;
    public String senderName;
    public String receiverId;
    public String receiverName;
    public String message;
    public String createdAt;
    
    public MessageEntity(String a, String b, String c, String d, String e, String f){
        senderId = a;
        senderName = b;
        receiverId = c;
        receiverName = d;
        message = e;
        createdAt = f;
    }
    
    public String getsenderId(){
        return senderId;
    }
        
    public String getsenderName(){
        return senderName;
    }
    
    public String getReceiverId(){
        return receiverId;
    }
    
    public String getReceiverName(){
        return receiverName;
    }
        
    public String getMessage(){
        return message;
    }
    
    public String getCreatedAt(){
        return createdAt;
    }
        
        
}

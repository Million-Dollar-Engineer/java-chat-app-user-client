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
    private final String senderId;
    private final String senderName;
    private final String receiverId;
    private final String receiverName;
    private final String message;
    private final String createdAt;
    
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

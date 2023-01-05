/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demos.ChatRoom;

import java.util.Vector;

/**
 *
 * @author 44485
 */
public class ChatManager {

    private ChatManager() {

    }
    
    private static final ChatManager cm=new ChatManager();
    
    public static ChatManager getChatManager(){
        return cm;
    }
    
    Vector<ChatSocket> vector=new Vector<ChatSocket>();
    
    public void AddChatPeople(ChatSocket cs){
        vector.add(cs);
    }
    
    public void Send(ChatSocket cs,String str){
        for (int i = 0; i < vector.size(); i++) {
            ChatSocket chatsocket=(ChatSocket)vector.get(i);
            if(!cs.equals(chatsocket)){
                chatsocket.Out(str);
            }
        }
    }

}

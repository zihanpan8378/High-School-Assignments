/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demos.ChatRoom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author 44485
 */
public class GetSocket extends Thread {
    public void run(){
        
        try{
            ServerSocket serversocket =new ServerSocket(62224);
            while(true){
                Socket socket= serversocket.accept();
                JOptionPane.showMessageDialog(null, "a Client have connected to port 62224");
                ChatSocket cs=new ChatSocket(socket);
                cs.start();
                ChatManager.getChatManager().AddChatPeople(cs);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

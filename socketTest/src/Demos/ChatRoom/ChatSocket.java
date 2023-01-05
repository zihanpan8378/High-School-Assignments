/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demos.ChatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 44485
 */
public class ChatSocket extends Thread {

    Socket socket;

    public ChatSocket(Socket socket) {
        this.socket = socket;
    }

    public void Out(String str) {
        try {
            socket.getOutputStream().write(str.getBytes("UTF-8"));

        } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(ChatSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run(){
        Out("success\n");
        try{
            BufferedReader br =new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
            
            String line=null;
            while((line=br.readLine())!=null){
                System.out.println(line);
                ChatManager.getChatManager().Send(this, line);
            }
        }  catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

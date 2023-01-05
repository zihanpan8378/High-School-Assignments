/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demos.ChatRoom.ThreadLearning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 44485
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serversocket = new ServerSocket(9999);
        Socket socket = serversocket.accept();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader bufferedReader = null;
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String str = bufferedReader.readLine();
                    System.out.println("client" + str);
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        bufferedReader.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();

    }
}

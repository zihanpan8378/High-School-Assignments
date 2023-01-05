/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketBasic.Second;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author 44485
 */
public class SocketServer {

    public static void main(String[] args) throws Exception {
        int port = 44485;
        Scanner in = new Scanner(System.in);
        ServerSocket server = new ServerSocket(port);

        System.out.println("Waiting for Connection");
        Socket socket = server.accept();
        System.out.println("Connected!");
        // InputStream inputStream = socket.getInputStream();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        byte[] bytes = new byte[1024];
        int len;
        System.out.println("1");
        while (i == 0) {
            InputStream inputStream = socket.getInputStream();
            
            System.out.println("2");
            try {
                while ((len = inputStream.read(bytes)) != -1) {
                    sb.append(new String(bytes, 0, len, "UTF-8"));
                }
                

            } catch (IOException ex) {
                Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (sb.equals("0")) {
                        inputStream.close();
                System.out.println("client quit!");
                break;
            } else {
                System.out.println("message from client: " + sb);
            }
            System.out.println("4");
            

        }


        /*InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();

        while ((len = inputStream.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len, "UTF-8"));
        }

        System.out.println("message from client: " + sb);*/
        // outputStream.close();
        socket.close();
        
        server.close();
    }

}

class allTimer {

    Timer timer = new Timer(10, new ActionListener() {
        public void actionPerformed(ActionEvent e) {

        }

    });
}

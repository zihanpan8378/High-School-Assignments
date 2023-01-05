/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketBasic.Second;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 44485
 */
public class SocketClient {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String host = "127.0.0.1";
        int port = 44485;
               Socket socket = new Socket(host, port);
        System.out.println("Connected!");
        int i=0;
        while (i==0) {
            OutputStream outputStream = socket.getOutputStream();
            System.out.print("wht u wanna say?: ");
            String message = in.next();
            if (message.equals("0")) {
                socket.shutdownOutput();
                break;
            } else {
                socket.getOutputStream().write(message.getBytes("UTF-8"));
                System.out.println("Message sent! You said " + message);
               outputStream.close();
            }

        }

        /*InputStream inputStream = socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len;
        StringBuilder sb=new StringBuilder();
        while((len = inputStream.read(bytes))!= -1){
            sb.append(new String(bytes,0,len,"UTF-8"));
        }
        System.out.println("message from Server: "+sb);
        outputStream.close();*/
        socket.close();
    }
}

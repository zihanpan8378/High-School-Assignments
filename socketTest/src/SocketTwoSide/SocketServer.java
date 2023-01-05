/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketTwoSide;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import java.net.ServerSocket;

/**
 *
 * @author 44485
 */
public class SocketServer {

    public static void main(String[] args) throws Exception {
        int port = 55533;
        ServerSocket server = new ServerSocket(port);
        System.out.println("Sserver will be waiting");
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;

         StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len, "UTF-8"));
        }
        System.out.println("Get message from client: " + sb);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello client, I got the message".getBytes("UTF-8"));

        inputStream.close();
        outputStream.close();
        socket.close();
        server.close();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketBasic;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 44485
 */
public class ScoketServer {
    public static void main(String[] args) throws IOException {
        int port=55533;
        ServerSocket server=new ServerSocket(port);
        
        System.out.println("Server is waiting!");
        Socket socket=server.accept();
        
        InputStream inputStream=socket.getInputStream();
        byte[] bytes=new byte[1024];
        
        int len;
        StringBuilder sb=new StringBuilder();
        while((len=inputStream.read(bytes))!=-1){
            sb.append(new String(bytes,0,len,"UTF-8"));
        }
        System.out.println("get message from client: "+sb);
        inputStream.close();
        socket.close();
        server.close();
    }
}

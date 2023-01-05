/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketBasic;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author 44485
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        String host="127.0.0.1";
        int port=55533;
        Socket socket=new Socket(host,port);
        OutputStream outputStream =socket.getOutputStream();
        String message="hello dd";
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        outputStream.close();
        socket.close();
    }
}

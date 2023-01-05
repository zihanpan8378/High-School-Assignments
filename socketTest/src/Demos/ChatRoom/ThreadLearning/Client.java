/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demos.ChatRoom.ThreadLearning;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author 44485
 */
public class Client {

    public static void main(String[] args) {
        try {
            
            Socket socket = new Socket("127.0.0.1", 9999);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner in =new Scanner(System.in);
            String str = in.next();
            bufferedWriter.write(str);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



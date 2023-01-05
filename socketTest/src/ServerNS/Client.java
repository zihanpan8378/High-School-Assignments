/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerNS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author 44485
 */
public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1",9999);
            
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
            
            while(true){
                String str = bufferedReader.readLine();
                bufferedWriter.write(str);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
            }
        }catch(IOException e){
           e.printStackTrace();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketThread;

/**
 *
 * @author 44485
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            Socket socket = serverSocket.accept();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
            BufferedReader b1 = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            final String name = b1.readLine();
            System.out.println(name + " connected!");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            System.out.println("Message: ");
                            String str = bufferedReader.readLine();

                            bufferedWriter.write("client: "+str);
                            bufferedWriter.write("\n");
                            bufferedWriter.flush();

                        }
                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                        String str;
                        while ((str = bufferedReader.readLine()) != null) {
                            System.out.println(str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }
}

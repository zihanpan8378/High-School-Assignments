/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketThread;

import java.io.*;

import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author 44485
 */
public class Client {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("enter client name:");
            Socket socket = new Socket("127.0.0.1", 9999);
            String name = in.next();
            BufferedWriter b1 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            b1.write(name);
            b1.flush();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));

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

            new Thread(new Runnable() {
                @Override
                public void run() {
                    int check = 0;
                    try {
                        while (true) {
                            if (check == 0) {
                                String str = "";
                                bufferedWriter.write(/*name+": "+*/str);
                                bufferedWriter.write("\n");
                                bufferedWriter.flush();
                                check++;
                            } else {
                                System.out.println("Message: ");
                                String str = bufferedReader.readLine();

                                bufferedWriter.write(name + ": " + str);
                                bufferedWriter.write("\n");
                                bufferedWriter.flush();
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                }

            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

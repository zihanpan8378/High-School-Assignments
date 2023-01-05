/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyanlou.j2se.network;
import java.awt.BorderLayout;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 *
 * @author 44485
 */
public class SocketServer extends JFrame {
    private JTextArea textArea_socketInfo;
    private ServerSocket server;
    private Socket socket;
    
    public SocketServer(){
        super();
        setTitle("Socket Server");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 280, 180);
        
        final JScrollPane scrollPane=new JScrollPane();
        getContentPane().add(scrollPane,BorderLayout.CENTER);
        textArea_socketInfo=new JTextArea();
        scrollPane.setViewportView(textArea_socketInfo);
    }
    
    public void getServer(){
        try{
            server=new ServerSocket(2015);
            textArea_socketInfo.append("server socket created\n");
            while(true){
                textArea_socketInfo.append("waiting\n");
                socket=server.accept();
                textArea_socketInfo.append("connected\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try{
            SocketServer serverFrame=new SocketServer();
            serverFrame.setVisible(true);
            serverFrame.getServer();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyanlou.j2se.network;

import javax.swing.*;
import java.net.*;
import java.awt.BorderLayout;

/**
 *
 * @author 44485
 */
public class SocketClinet extends JFrame {

    private Socket socket;
    private JTextArea textArea_socketInfo;

    public SocketClinet() {
        super();
        setTitle("Socket Client");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 200, 180);
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        textArea_socketInfo = new JTextArea();
        scrollPane.setViewportView(textArea_socketInfo);

    }

    private void connect() {
        textArea_socketInfo.append("trying to connect...\n");
        try {
            socket = new Socket("127.0.0.1", 2015);
            textArea_socketInfo.append("connected\n");
            InetAddress serverAddress = socket.getInetAddress();
            String serverIP = serverAddress.getHostAddress();
            int serverPort = socket.getPort();
            InetAddress localAddress = socket.getLocalAddress();
            String clinetIP = localAddress.getHostAddress();
            int clinetPort = socket.getLocalPort();

            textArea_socketInfo.append("Server IP: " + serverIP + "\n");
            textArea_socketInfo.append("Server port: " + serverPort + "\n");
            textArea_socketInfo.append("client IP: : " + clinetIP + "\n");
            textArea_socketInfo.append("client port: : " + clinetPort + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            SocketClinet clientFrame = new SocketClinet();
            clientFrame.setVisible(true);
            clientFrame.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

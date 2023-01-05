/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UPD;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author 44485
 */
public class UPDA {
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        byte[] bs="I am A, send message to B".getBytes();
        InetAddress desIp=InetAddress.getLocalHost();
        DatagramPacket p=new DatagramPacket(bs,bs.length,desIp,10010);
        DatagramSocket socket_A=new DatagramSocket(10086);
        socket_A.send(p);
        socket_A.close();
    }
}

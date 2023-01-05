/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UPD;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
/**
 *
 * @author 44485
 */
public class UDPB {
    public static void main(String[] args) throws SocketException, IOException {
        byte[] bs=new byte[500];
        DatagramPacket p=new DatagramPacket(bs,bs.length);        
        DatagramSocket socket_B=new DatagramSocket(10010);
        socket_B.receive(p);
        System.out.println(new String(bs,0,p.getLength()));
        socket_B.close();
    }
}

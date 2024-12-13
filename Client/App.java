package Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

import Classes.Crewmate;

class Client{
public static void main(String[] args) throws IOException
    {
        
        DatagramSocket socket = new DatagramSocket();

        String ip = "172.16.102.112";
        
        Crewmate c1 = new Crewmate(10, 10);

        String mex = "x: " +c1.getX() + "y: " +c1.getY();

        byte[] buffer = mex.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        packet.setAddress(InetAddress.getByName(ip));
        packet.setPort(12345);
        socket.send(packet);

        byte[] bufferRisp = new byte[1500]; //1500 per MTU (cerca cos'è)
        DatagramPacket packetRisp = new DatagramPacket(bufferRisp, bufferRisp.length);
        socket.receive(packetRisp);
        String mexRisp = new String(packetRisp.getData(),0,packetRisp.getLength());
        System.out.println(mexRisp);


        
    }
}
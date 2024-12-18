package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

import Server.ServerClasses.GameManager;
import Server.ServerClasses.GameState;

public class App
{
    public static void main(String[] args) throws IOException
    {

        final int PORT = 12345; // Porta UDP per il server
        DatagramSocket socket=new DatagramSocket(PORT);
        GameManager manager = new GameManager();    


        byte[] buffer = new byte[1500];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
       
        while(/*!manager.getState().isFinished()*/true)
        {
            /* 
            socket.receive(packet);
            String mex = new String(packet.getData(),0,packet.getLength());
            System.out.println(mex);
    
            if(mex.startsWith("ABBA"))
            {
                String mexRisp = "BAAB "+mex.substring(4,mex.length());
        
                byte[] bufferRisp = mexRisp.getBytes();
                DatagramPacket packetRisp = new DatagramPacket(bufferRisp, bufferRisp.length);
                packetRisp.setAddress(packet.getAddress());
                packetRisp.setPort(packet.getPort());
                socket.send(packetRisp); 
            }
            else
            {
                Scanner sc = new Scanner(System.in);
                String err = sc.nextLine();
                String mexRisp = "RENFE "+err;

                byte[] bufferRisp = mexRisp.getBytes();
                DatagramPacket packetRisp = new DatagramPacket(bufferRisp, bufferRisp.length);
                packetRisp.setAddress(packet.getAddress());
                packetRisp.setPort(packet.getPort());
                socket.send(packetRisp); 
            }
            

            socket.receive(packet);
            String mex = new String(packet.getData(),0,packet.getLength());
            System.out.println("Messaggio ricevuto: "+mex);
            Scanner sc = new Scanner(System.in);

            String mexRisp = "Ciao ";
            mexRisp += sc.nextLine();

            byte[] bufferRisp = mexRisp.getBytes();
            DatagramPacket packetRisp = new DatagramPacket(bufferRisp, bufferRisp.length);
            packetRisp.setAddress(packet.getAddress());
            packetRisp.setPort(packet.getPort());
            socket.send(packetRisp); 
            */
            socket.receive(packet);
            String mex = new String(packet.getData(),0,packet.getLength());
            System.out.println("Messaggio ricevuto: "+mex);
            Scanner sc = new Scanner(System.in);

            String mexRisp = "Ciao ";
            mexRisp += sc.nextLine();

            byte[] bufferRisp = mexRisp.getBytes();
            DatagramPacket packetRisp = new DatagramPacket(bufferRisp, bufferRisp.length);
            packetRisp.setAddress(packet.getAddress());
            packetRisp.setPort(packet.getPort());
            socket.send(packetRisp); 

            
        }       
    }
}
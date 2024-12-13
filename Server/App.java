package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class App
{
    public static void main(String[] args) throws IOException
    {
        DatagramSocket socket = new DatagramSocket(12345);

        byte[] buffer = new byte[1500]; //1500 per MTU (cerca cos'è)
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
       
        while(true)
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
              
        }       
    }
}
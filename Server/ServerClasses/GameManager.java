package Server.ServerClasses;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

import Classes.Entity;
import Client.ClientClasses.GUIHandler;
import Client.ClientClasses.MyPanel;

public class GameManager extends Thread{
    
    private GameState state;
    private CoordinatesHandler ch;

    public GameManager() //Ogni volta che riceve un messaggio fa quello che deve fare è un thread
    {
        this.state = new GameState();
        this.ch = new CoordinatesHandler(new GUIHandler(new MyPanel()), new ArrayList<Entity>());   
    }

    public void run() 
    {
        while(!this.state.isFinished())
        {   
            try
            {
                final int PORT = 12345; // Porta UDP per il server
                DatagramSocket socket = new DatagramSocket(PORT);
                GameManager manager = new GameManager();    
        
        
                byte[] buffer = new byte[1500];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            
                socket.receive(packet);
                String mex = new String(packet.getData(),0,packet.getLength());
                System.out.println(mex);
        
                String mexRisp = this.ch.update();
                    
                byte[] bufferRisp = mexRisp.getBytes();
                DatagramPacket packetRisp = new DatagramPacket(bufferRisp, bufferRisp.length);
                packetRisp.setAddress(packet.getAddress());
                packetRisp.setPort(packet.getPort());
                socket.send(packetRisp);     
            } catch (Exception e){
                // TODO: handle exception
                e.printStackTrace();
            } 
        }   


        if(this.state.checkKilled())
        {

        }
        else if(this.state.checkTasks())
        {
            
        }
        
    }
}

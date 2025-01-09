package Server.ServerClasses;

import Classes.*;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class CoordinatesHandler
{
    ArrayList<Entity> players;

    public CoordinatesHandler(ArrayList<Entity> players)
    {
        this.players = players;
    }

    //Controlla le coordinate di player X
    // per sapere il player scorro la lista di player controllo dalla socket l'ip e la port per capire se è il personaggio corretto

    public void update(InetAddress ip, int port, String mex) throws Exception
    {
        for (Entity p : this.players) 
        {
            final int PORT = 12345; 
            DatagramSocket socket = new DatagramSocket(PORT);

            Object[] objs = this._getCoordinatesByMex(mex);

            String mexRisp = "x: " +objs[0] + " y: " + objs[1] + " dir: " + objs[2]+" img: "+objs[3];
            byte[] buffer = mexRisp.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            packet.setAddress(ip);
            packet.setPort(PORT);

            socket.send(packet);
        }
    }

    private Object[] _getCoordinatesByMex(String mex)
    {
        try
        {
            String[] parts = mex.split(" ");
            int x = Integer.parseInt(parts[0].split(":")[1]);
            int y = Integer.parseInt(parts[1].split(":")[1]);
            String direction = parts[2].split(":")[1];
            String image = parts[3].split(":")[1]; 

            Object[] objects = {x, y, direction, image};
            return objects;
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        Object[] objects = {0, 0, "up", "up1"};
        return objects;
    }
}
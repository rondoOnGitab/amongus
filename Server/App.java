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
        GameManager manager = new GameManager();
        manager.start();
    }
}
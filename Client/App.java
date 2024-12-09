package Client;

import Classes.*; // Import eventuali classi definite dall'utente.

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.io.IOException;

class App {
    public static void main(String[] args) throws IOException {
        // Crea un socket UDP per inviare e ricevere pacchetti
        DatagramSocket socket = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci il messaggio da inviare: ");
        String mex = sc.nextLine(); // Legge il messaggio da inviare

        String ip = "127.0.0.1"; // Indirizzo IP del server

        // Prepara e invia il pacchetto al server
        byte[] buffer = mex.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ip), 12345);
        socket.send(packet);

        System.out.println("Messaggio inviato: " + mex);

        // Riceve la risposta dal server
        byte[] bufferRisp = new byte[1500]; // Dimensione buffer conforme a MTU
        DatagramPacket packetRisp = new DatagramPacket(bufferRisp, bufferRisp.length);
        socket.receive(packetRisp);

        // Converte il messaggio ricevuto in stringa e lo stampa
        String mexRisp = new String(packetRisp.getData(), 0, packetRisp.getLength());
        System.out.println("Risposta dal server: " + mexRisp);
    }
}
